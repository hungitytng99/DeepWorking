package com.icthust.deepworking.ui.daily;

import android.content.Context;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.hust.library.DateTimeInterpreter;
import com.hust.library.WeekDayView;
import com.hust.library.WeekHeaderView;
import com.hust.library.WeekView;
import com.hust.library.WeekViewEvent;
import com.icthust.deepworking.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class DailyFragment extends Fragment implements WeekDayView.MonthChangeListener, WeekDayView.EventClickListener, WeekDayView.EventLongPressListener, WeekDayView.ScrollListener {

    private DailyViewModel dailyViewModel;
    public WeekDayView mWeekView;
    private WeekHeaderView mWeekHeaderView;
    private TextView mTv_date;
    private WeekDayView.MonthChangeListener monthChangeListener;

    List<WeekViewEvent> mNewEvent = new ArrayList<WeekViewEvent>();

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dailyViewModel =
                ViewModelProviders.of(this).get(DailyViewModel.class);

        View root = inflater.inflate(R.layout.fragment_daily, container, false);
        mWeekView = (WeekDayView) root.findViewById(R.id.weekdayview);

        mWeekView.setMonthChangeListener(this);

        assignViews(inflater, container);

        return root;
    }

    private void assignViews(@NonNull LayoutInflater inflater,
                             ViewGroup container) {
        View root = inflater.inflate(R.layout.fragment_daily, container, false);

        mWeekHeaderView = (WeekHeaderView) root.findViewById(R.id.weekheaderview);
        mTv_date = (TextView) root.findViewById(R.id.tv_date);
//        //init WeekView
        mWeekView.setEventLongPressListener(this);
        mWeekView.setOnEventClickListener(this);
        mWeekView.setScrollListener(this);
        mWeekHeaderView.setDateSelectedChangeListener(new WeekHeaderView.DateSelectedChangeListener() {
            @Override
            public void onDateSelectedChange(Calendar oldSelectedDay, Calendar newSelectedDay) {
                mWeekView.goToDate(newSelectedDay);
            }
        });
        mWeekHeaderView.setScrollListener(new WeekHeaderView.ScrollListener() {
            @Override
            public void onFirstVisibleDayChanged(Calendar newFirstVisibleDay, Calendar oldFirstVisibleDay) {
                mWeekView.goToDate(mWeekHeaderView.getSelectedDay());
            }
        });
        setupDateTimeInterpreter(false);

    }


    /**
     * Set up a date time interpreter which will show short date values when in week view and long
     * date values otherwise.
     *
     * @param shortDate True if the date values should be short.
     */
    private void setupDateTimeInterpreter(final boolean shortDate) {
        final String[] weekLabels = {"日", "一", "二", "三", "四", "五", "六"};
        mWeekView.setDateTimeInterpreter(new DateTimeInterpreter() {
            @Override
            public String interpretDate(Calendar date) {
                SimpleDateFormat weekdayNameFormat = new SimpleDateFormat("EEE", Locale.getDefault());
                String weekday = weekdayNameFormat.format(date.getTime());
                SimpleDateFormat format = new SimpleDateFormat("d", Locale.getDefault());
                return format.format(date.getTime());
            }

            @Override
            public String interpretTime(int hour) {
                return String.format("%02d:00", hour);

            }

            @Override
            public String interpretWeek(int date) {
                if (date > 7 || date < 1) {
                    return null;
                }
                return weekLabels[date - 1];
            }
        });
    }

    @Override
    public void onEventClick(WeekViewEvent event, RectF eventRect) {

    }

    @Override
    public List<WeekViewEvent> onMonthChange(int newYear, int newMonth) {
        List<WeekViewEvent> events = new ArrayList<WeekViewEvent>();

        return events;
    }

    @Override
    public void onEventLongPress(WeekViewEvent event, RectF eventRect) {
    }

    @Override
    public void onFirstVisibleDayChanged(Calendar newFirstVisibleDay, Calendar oldFirstVisibleDay) {

    }

    @Override
    public void onSelectedDaeChange(Calendar selectedDate) {

    }
}