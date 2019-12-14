class q19 {
	static boolean isLeapYear(int y) {
		return y%400==0||(y%4==0&&y%100!=0); 
	}

	static int days_of_a_month(int m, int year) {
		if (m==9||m==4||m==6||m==11)
			return 30;
		else if (m==1||m==3||m==5||m==7||m==8||m==10||m==12)
			return 31;
		else if (isLeapYear(year))
			return 29;
		else
			return 28;
	}

	public static void main(String[] args) {
		int res = 0;
		int day = 2; //1901.01.01 was a Tuesday.
		int year = 1901;
		int month = 1;
		int dom, add;
		while (year<=2000){
			dom = days_of_a_month(month, year);
			add = dom%7;
			day += add;
			if (day>7) day-=7;
			if (day==7) res++;
			if (month==12) {
				month=1;
				year++;
			}
			else month++;
		}
		System.out.println("There are "+res+" such Sundays.");
	}
}