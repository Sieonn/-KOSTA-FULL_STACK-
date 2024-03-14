package class1.ex;

public class MovieReviewMain {
    public static void main(String[] args) {
        MovieReview inception = new MovieReview();
        inception.title = "인셉션";
        inception.review="인생은 무한 루프";

        MovieReview abouttime = new MovieReview();
        abouttime.title = "어바웃 타임";
        abouttime.review="인생 시간 영화";
        MovieReview [] movieReviews = new MovieReview[]{inception,abouttime};

        for(int i=0; i<movieReviews.length; i++){
            System.out.println("영화 제목:" +movieReviews[i].title+ " 리뷰:"+movieReviews[i].review);
        }
        System.out.println("------------------------------------------");
        for (MovieReview m : movieReviews) {
            System.out.println("영화 제목:" +m.title+ " 리뷰:"+m.review);

        }
    }
}
