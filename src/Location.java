public enum Location {
    BRIDGEWATER("Bridgewater", "08807", "Somerset County"),
    EDISON("Edison", "08837", "Middlesex County"),
    FRANKLIN("Franklin", "08873", "Somerset County"),
    PISCATAWAY("Piscataway", "08854", "Middlesex County"),
    SOMERVILLE("Somerville", "08876", "Somerset County");

    private final String name;
    private final String zipCode;
    private final String county;

    Location(String name, String zipCode, String county) {
        this.name = name;
        this.zipCode = zipCode;
        this.county = county;
    }

    public String getName() {

        return name;
    }

    public String getZipCode() {

        return zipCode;
    }

    public String getCounty() {

        return county;
    }
    public static Location findLocation(String input) {
        for (Location location : Location.values()) {
            if (location.name.equalsIgnoreCase(input)) {
                return location;
            }
        }
        return null; // If no match is found
    }

}

