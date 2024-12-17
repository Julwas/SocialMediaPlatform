package social.media.platform.enams;

public enum PostPopularity {
    LOW("Low Popularity", 1),
    MEDIUM("Medium Popularity", 5),
    HIGH("High Popularity", 10);

    private String popularityDescription;
    private int score;

    PostPopularity(String popularityDescription, int score) {
        this.popularityDescription = popularityDescription;
        this.score = score;
    }

    public String getPopularityDescription() {
        return popularityDescription;
    }

    public int getScore() {
        return score;
    }

    public void displayPopularityInfo() {
        System.out.println("Post Popularity: " + popularityDescription + " (Score: " + score + ")");
    }

    static {
        System.out.println("Post Popularity Enum Initialized");
    }
}
