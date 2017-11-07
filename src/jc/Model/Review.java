package jc.Model;

import java.text.DecimalFormat;

public class Review {
	private int mRating;
	private String mReview;
	public boolean edited;
	public Review(String review,int rating, boolean edited){
		mRating=rating;mReview=review;this.edited = edited;
	}
	public double getmRating() {
		return mRating;
	}
	public void setmRating(int mRating) {
		this.mRating = mRating;
	}
	public String getmReview() {
		return mReview;
	}
	public void setmReview(String mReview) {
		this.mReview = mReview;
	}
	@Override public String toString(){
		DecimalFormat f=new DecimalFormat("#.0");
		return (edited?"(Edited) \n":"") + f.format(mRating)+" / 5.0\n"+mReview+"\n\n";
	}
}
