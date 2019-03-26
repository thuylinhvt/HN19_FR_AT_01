/*
*
* (C) Copyright 2019Fresher Academy
* Author apple
* Date Mar 7, 2019
* Version 1.0
*
*/
package com.fpt.excercise3.model;

public class MyTime {

	private int hour = 0;
	private int minute = 0;
	private int second = 0;
	
	public MyTime() {
		// TODO Auto-generated constructor stub
	}

	public MyTime(int hour, int minute, int second) {
		super();
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	public void setTime(int hour, int minute, int second) {
		if( 0<=hour && hour <=23 && 0<= minute && minute<=59 && 0<=second && second <= 59) {
			this.hour = hour;
			this.minute = minute;
			this.second = second;
		}else {
			throw new IllegalArgumentException("Invalid hour, minute, or second!");
		}
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		if(0<= hour && hour <=23) {
		this.hour = hour;
		}else {
			throw new IllegalArgumentException(" Invalid hour!");
		}
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		if(0<=minute && minute <=59) {
		this.minute = minute;
		}else {
			throw new IllegalArgumentException("Invalid minute!");
		}
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		if(0<=second && second <=59) {
		this.second = second;
		}else {
			throw new IllegalArgumentException("Invalid second!");
		}
	}

	public MyTime nextSecond() {
		if(0<=second && second<59) {
			second ++;
			this.setSecond(second);
		}else {
			second = 0;
			this.setSecond(second);
			if(0 <= minute && minute<59) {
				minute++;
				this.setMinute(minute);
			}else {
				minute = 0;
				this.setMinute(minute);
				if(0<=hour && hour <23) {
					hour++;
					this.setHour(hour);
				}else {
					hour = 0;
					this.setHour(hour);
				}
			}
			
		}
		return new MyTime(hour, minute, second);
	}
	
	public MyTime nextMinute() {
		if(0 <= minute && minute<59) {
			minute++;
			this.setMinute(minute);
		}else {
			minute = 0;
			this.setMinute(minute);
			if(0<=hour && hour <23) {
				hour++;
				this.setHour(hour);
			}else {
				hour = 0;
				this.setHour(hour);
			}
		}
		return new MyTime(hour, minute, second);
	}
	
	public MyTime nextHour() {
		if(0<=hour && hour <23) {
			hour++;
			this.setHour(hour);
		}else {
			hour = 0;
			this.setHour(hour);
		}
		return new MyTime(hour, minute, second);
	}
	
	public MyTime previousSecond() {
		if(0 <second && second <=59) {
			second--;
			this.setSecond(second);
		}else {
			second = 59;
			this.setSecond(second);
			if(0<minute && minute <=59) {
				minute--;
				this.setMinute(minute);
			}else {
				minute = 59;
				this.setMinute(minute);
				if(0<hour && hour <=23) {
					hour--;
					this.setHour(hour);
				}else {
					hour = 23;
					this.setHour(hour);
				}
			}
		}
		return new MyTime(hour, minute, second);
	}
	
	
	public MyTime  previousMinute() {
		if(0<minute && minute <=59) {
			minute--;
			this.setMinute(minute);
		}else {
			minute = 59;
			this.setMinute(minute);
			if(0<hour && hour <=23) {
				hour--;
				this.setHour(hour);
			}else {
				hour = 23;
				this.setHour(hour);
			}
		}
		return new MyTime(hour, minute, second);
	}
	
	public MyTime previousHour() {
		if(0<hour && hour <=23) {
			hour--;
			this.setHour(hour);
		}else {
			hour = 23;
			this.setHour(hour);
		}
		return new MyTime(hour, minute, second);
	}
	
	
	@Override
	public String toString() {
		String sHour, sMinute, sSecond;
		if(0<=hour && hour<10) {
			sHour = "0" + hour;
		}else {
			sHour = ""+ hour;
		}
		if(0<=second && second <10) {
			sSecond = "0" + second;
		}else {
			sSecond = "" + second;
		}
		if(0<=minute && minute <10) {
			sMinute = "0" + minute;
		}else {
			sMinute = "" + minute;
		}
		return sHour+":"+sMinute+":"+sSecond;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hour;
		result = prime * result + minute;
		result = prime * result + second;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyTime other = (MyTime) obj;
		if (hour != other.hour)
			return false;
		if (minute != other.minute)
			return false;
		if (second != other.second)
			return false;
		return true;
	}
	
	
	
	
}
