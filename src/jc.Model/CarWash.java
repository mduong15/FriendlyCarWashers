package jc.Model;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CarWash {
	private String mName;
	private double mPrice;
	private double mAverageRating;
	private String mAddress;
	private ArrayList<Review> mReviews;
	public CarWash(String name,double price,double avrgRating,String address,ArrayList<Review> reviews){
		mName=name;mPrice=price;mAverageRating=avrgRating;mAddress=address;
		if(reviews!=null)mReviews=new ArrayList<>(reviews);
	}
	public String getName() {
		return mName;
	}
	public void setName(String mName) {
		this.mName = mName;
	}
	public double getPrice() {
		return mPrice;
	}
	public void setPrice(double mPrice) {
		this.mPrice = mPrice;
	}
	public double getAverageRating() {
		return mAverageRating;
	}
	public void setAverageRating(double mAverageRating) {
		this.mAverageRating = mAverageRating;
	}
	public String getAddress() {
		return mAddress;
	}
	public void setAddress(String mAddress) {
		this.mAddress = mAddress;
	}

	public ArrayList<Review> getReviews() {
		return new ArrayList<>(mReviews);
	}
	public void setReviews(ArrayList<Review> mReviews) {
		this.mReviews =new ArrayList<>(mReviews);
	}
	@Override public String toString(){
		DecimalFormat f=new DecimalFormat("#.0");
		DecimalFormat f2=new DecimalFormat("#.00");
		return mName+", $"+f2.format(mPrice)+", "+f.format(mAverageRating)+"/5.0, "+mAddress;
	}
	
	
}
