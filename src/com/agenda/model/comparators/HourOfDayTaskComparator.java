package com.agenda.model.comparators;

import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;

import com.agenda.model.AgendaTask;;

public class HourOfDayTaskComparator implements Comparator<AgendaTask> {

	@Override
	public int compare(AgendaTask o1, AgendaTask o2) {
		return o1.getDateBegin().get(Calendar.HOUR_OF_DAY) - (o2.getDateBegin().get(Calendar.HOUR_OF_DAY));
	}

}
