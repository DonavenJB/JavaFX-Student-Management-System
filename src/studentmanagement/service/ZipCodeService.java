package studentmanagement.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class ZipCodeService {
    private static final String ENDPOINT_PATTERN = "https://api.zippopotam.us/us/%s";

    public static ZipInfo fetchPostalInfo(String zipCode) throws IOException {
        String apiUrl = String.format(ENDPOINT_PATTERN, zipCode);
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode != 200) {
            throw new IOException("Invalid ZIP code or API error. Response Code: " + responseCode);
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        StringBuilder response = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        Gson gson = new Gson();
        ZipCode zipCodeResponse = gson.fromJson(response.toString(), ZipCode.class);

        if (zipCodeResponse.getPlaces() != null && zipCodeResponse.getPlaces().length > 0) {
            ZipCode.Place place = zipCodeResponse.getPlaces()[0];
            return new ZipInfo(place.getPlaceName(), place.getState());
        } else {
            throw new IOException("No place information found for ZIP code: " + zipCode);
        }
    }

    class ZipCode {
        @SerializedName("post code")
        private String postCode;
        private String country;

        @SerializedName("country abbreviation")
        private String countryabbreviation;
        private Place[] places;

        public String getPostCode() {
            return postCode;
        }

        public String getCountry() {
            return country;
        }

        public String getCountryAbbreviation() {
            return countryabbreviation;
        }

        public Place[] getPlaces() {
            return places;
        }

        public static class Place {
            @SerializedName("place name")
            private String placename;
            private String longitude;
            private String state;

            @SerializedName("state abbreviation")
            private String stateabbreviation;
            private String latitude;

            public String getPlaceName() {
                return placename;
            }

            public String getLongitude() {
                return longitude;
            }

            public String getState() {
                return state;
            }

            public String getStateAbbreviation() {
                return stateabbreviation;
            }

            public String getLatitude() {
                return latitude;
            }
        }
    }

    public static class ZipInfo {
        private String city;
        private String state;

        public ZipInfo(String city, String state) {
            this.city = city;
            this.state = state;
        }

        public String fetchCityLabel() {
            return city;
        }

        public String fetchRegionLabel() {
            return state;
        }
    }
}
