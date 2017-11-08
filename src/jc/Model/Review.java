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
	public String starRating (double AverageRating) 
	{
		String starRate = "";
		int rating = (int) Math.round(AverageRating);
		for (int i = 1; i <= rating; i++)
		starRate += "★";
		
		for (int i = 0; i < 5 - rating; i++)
			starRate += "☆";
		return starRate;
	
	}
	@Override public String toString(){
		return starRating(mRating)+ "\n"  +mReview+"\n\n";
	}
}
