package enums;

public enum APIEnum {
    
    IMDB("https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060"),
    NASA("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14"),
    ANIMAIS("https://zoo-animal-api.herokuapp.com/animals/rand/10");

    private String url;


    APIEnum(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

}
