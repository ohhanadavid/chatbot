/*package com.handson.chatbot.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FanFavorites {
    
    private Data data;
    private Extensions extensions;

   

    @Getter
    @Setter
    @NoArgsConstructor
@AllArgsConstructor
    public class Data{
        FanPicksTitles fanPicksTitles;


    }
    @Getter
    @Setter
    @NoArgsConstructor
@AllArgsConstructor
    public class FanPicksTitles{

        Edges edges;
    }
    @Getter
    @Setter
    @NoArgsConstructor
@AllArgsConstructor
    public class Edges{
        List<Node> node;

    }
    @Getter
    @Setter
    @NoArgsConstructor
@AllArgsConstructor
    public class Node{
        String id;
        TitleText titleText;
        TitleType titleType;
        OriginalTitleText originalTitleText;
        PrimaryImage primaryImage;
        ReleaseYear releaseYear;
        RatingsSummary ratingsSummary;
        Runtime runtime;
        Certificate certificate;
        CanRate canRate;
        TitleGenres titleGenres;
        Boolean canHaveEpisodes;
        LatestTrailer latestTrailer;
        String primaryWatchOption;

    }
    @Getter
    @Setter
    @NoArgsConstructor
@AllArgsConstructor
    public class TitleText{
        String text;
    }
    @Getter
    @Setter
    @NoArgsConstructor
@AllArgsConstructor
    public class TitleType{
        String id;
        String text;
        Boolean canHaveEpisodes;
        DisplayableProperty displayableProperty;
    }
    @Getter
    @Setter
    @NoArgsConstructor
@AllArgsConstructor
    public class OriginalTitleText{
        String text;
    }
    @Getter
    @Setter
    @NoArgsConstructor
@AllArgsConstructor
    public class PrimaryImage{
        String id;
        Integer width;
        Integer height;
        String url;
        Caption caption;
        @Getter
        @Setter
        @NoArgsConstructor
@AllArgsConstructor
        public class Caption{
            String plainText;
        }
    }
    @Getter
    @Setter
    @NoArgsConstructor
@AllArgsConstructor
    public class ReleaseYear{
        Integer year;
        Integer endYear;

    }
    @Getter
    @Setter
    @NoArgsConstructor
@AllArgsConstructor
    public class RatingsSummary{
        Double aggregateRating;
        Integer voteCount;
    }
    @Getter
    @Setter
    @NoArgsConstructor
@AllArgsConstructor
    public class RunTime{
        Integer seconds;
    }
    @Getter
    @Setter
    @NoArgsConstructor
@AllArgsConstructor
    public class Certificate {
        String rating;
    }
    @Getter
    @Setter
    @NoArgsConstructor
@AllArgsConstructor
    public class CanRate {
        Boolean isRatable;
    }
    @Getter
    @Setter
    @NoArgsConstructor
@AllArgsConstructor
    public class TitleGenres{
        List<Genre> genres;
        @Getter
        @Setter
        @NoArgsConstructor
@AllArgsConstructor
        public class Genre{
            String text;
        }
    }
    @Getter
    @Setter
    @NoArgsConstructor
@AllArgsConstructor
    public class LatestTrailer{
        String id;
    }
    @Getter
    @Setter
    @NoArgsConstructor
@AllArgsConstructor
    public class DisplayableProperty{
        Value value;
        @Getter
        @Setter
        @NoArgsConstructor
@AllArgsConstructor
        public class Value{
            String plainText;
        
        }
    }
    @Getter
    @Setter
    @NoArgsConstructor
@AllArgsConstructor
    public class Extensions{
        String disclaimer;
        ExperimentalFields experimentalFields;
    }
    @Getter
    @Setter
    @NoArgsConstructor
@AllArgsConstructor
    public class ExperimentalFields{
        List<String>ratings;
        List<String>watch;
        List<String>video;
        List<String>janet;
        List<String>markdown;

    }
}*/
package com.handson.chatbot.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class FanFavorites {
    private Data data;
    private Extensions extensions;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Data {
        private FanPicksTitles fanPicksTitles;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FanPicksTitles {
        private List<Edge> edges;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Edge {
        private Node node;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown=true)
    public static class Node {
        private String id;
        private TitleText titleText;
      //  private TitleType titleType;
       // private OriginalTitleText originalTitleText;
      //  private PrimaryImage primaryImage;
        private ReleaseYear releaseYear;
        private RatingsSummary ratingsSummary;
       // private MovieRuntime runtime;
       // private Certificate certificate;
      //  private CanRate canRate;
       // private TitleGenres titleGenres;
       // private Boolean canHaveEpisodes;
       // private LatestTrailer latestTrailer;
       // private Object primaryWatchOption;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MovieRuntime {
        private Integer seconds;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TitleText {
        private String text;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TitleType {
        private String id;
        private String text;
        private Boolean canHaveEpisodes;
        private DisplayableProperty displayableProperty;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OriginalTitleText {
        private String text;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PrimaryImage {
        private String id;
        private Integer width;
        private Integer height;
        private String url;
        private Caption caption;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Caption {
        private String plainText;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReleaseYear {
        private Integer year;
        private Integer endYear;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RatingsSummary {
        private Double aggregateRating;
        private Integer voteCount;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Certificate {
        private String rating;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CanRate {
        private Boolean isRatable;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TitleGenres {
        private List<GenreWrapper> genres;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GenreWrapper {
        private Genre genre;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Genre {
        private String text;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LatestTrailer {
        private String id;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DisplayableProperty {
        private Value value;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Value {
        private String plainText;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Extensions {
        private String disclaimer;
        private ExperimentalFields experimentalFields;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ExperimentalFields {
        private List<String> ratings;
        private List<String> watch;
        private List<String> video;
        private List<String> janet;
        private List<String> markdown;
    }
}
