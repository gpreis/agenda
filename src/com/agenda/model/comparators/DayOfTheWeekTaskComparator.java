package com.agenda.model.comparators;

import java.util.Comparator;
import java.util.GregorianCalendar;

import com.agenda.model.AgendaTask;;

public class DayOfTheWeekTaskComparator implements Comparator<AgendaTask> {

	@Override
	public int compare(AgendaTask o1, AgendaTask o2) {
		return o1.getDayOfTheWeek().compareTo(o2.getDayOfTheWeek());
	}

}
