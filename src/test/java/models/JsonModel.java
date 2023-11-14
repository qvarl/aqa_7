package models;

public class JsonModel {
    public Image image;

    public static class Image {
        public Integer width;
        public Integer height;
        public String title;
        public Boolean visible;
        public Integer[] ids;
    }
}
