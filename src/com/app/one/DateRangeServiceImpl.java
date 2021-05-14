package com.app.one;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DateRangeServiceImpl {

	public List<DateRange> mergeDate(List<DateRange> dateRanges) {
		List<DateRange> response = new ArrayList<DateRange>();
		try {

			System.out.println(dateRanges.size());
			if (dateRanges != null && !dateRanges.isEmpty())
				for (int i = 0; i < dateRanges.size(); i++) {

					LocalDate temp = dateRanges.get(i).getEndDate();
					for (int j = i + 1; j < dateRanges.size(); j++) {

						Boolean result = temp.isAfter(dateRanges.get(j).getStartDate())
								|| temp.isEqual(dateRanges.get(j).getStartDate());

						if (result == true) {

							response.add(
									new DateRange(dateRanges.get(i).getStartDate(), dateRanges.get(j).getEndDate()));

						}

					}

				}

			System.out.println("Merge Date Range:" + response.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return response;

	}

	public static void main(String args[]) {

		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MMM-yyyy");

		LocalDate d1 = LocalDate.parse("01-Jan-2014", format);
		LocalDate d2 = LocalDate.parse("30-Jan-2014", format);
		LocalDate d3 = LocalDate.parse("16-Jan-2014", format);
		LocalDate d4 = LocalDate.parse("15-Feb-2014", format);
		LocalDate d5 = LocalDate.parse("10-Mar-2014", format);
		LocalDate d6 = LocalDate.parse("15-Apr-2014", format);
		LocalDate d7 = LocalDate.parse("10-Apr-2014", format);
		LocalDate d8 = LocalDate.parse("15-May-2014", format);
		DateRange date1 = new DateRange(d1, d2);
		DateRange date2 = new DateRange(d3, d4);
		DateRange date3 = new DateRange(d5, d6);
		DateRange date4 = new DateRange(d7, d8);

		List<DateRange> dateRanges = new ArrayList<DateRange>();
		dateRanges.add(date1);
		dateRanges.add(date2);
		dateRanges.add(date3);
		dateRanges.add(date4);
		DateRangeServiceImpl impl = new DateRangeServiceImpl();
		impl.mergeDate(dateRanges);

	}

}
