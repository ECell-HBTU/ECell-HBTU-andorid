package com.example.arnav.ecellapplication;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.arnav.ecellapplication.swipeView.CardStackView;
import com.example.arnav.ecellapplication.swipeView.SwipeDirection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FeedbackActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private CardStackView cardStackView;
    private EventCardAdapter adapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_feedback);
            setup();
            reload();
        }

        //TODO(1)-send the id of image instead of the actual resource
        private List<EventCard> createEvents() {
            List<EventCard> eventList = new ArrayList<>();
            eventList.add(new EventCard("Event 1", "july",getResources().getDrawable(R.mipmap.event4),null ));
            eventList.add(new EventCard("Event 2", "august",getResources().getDrawable(R.mipmap.event2),null));
            eventList.add(new EventCard("Event 3", "may",getResources().getDrawable(R.mipmap.event1),null ));
            eventList.add(new EventCard("Event 4", "january",getResources().getDrawable(R.mipmap.event7),null ));
            eventList.add(new EventCard("Event 5", "december",getResources().getDrawable(R.mipmap.event5),null ));
            eventList.add(new EventCard("Event 6", "january",getResources().getDrawable(R.mipmap.event6),null ));
            eventList.add(new EventCard("Event ...", "february",getResources().getDrawable(R.mipmap.event8),null ));
            eventList.add(new EventCard("Event x", "april",getResources().getDrawable(R.mipmap.event5),null ));
            return eventList;
        }

        private EventCardAdapter createEventCardAdapter() {
            final EventCardAdapter adapter = new EventCardAdapter(getApplicationContext());
            adapter.addAll(createEvents());
            return adapter;
        }

        private void setup() {
            progressBar = findViewById(R.id.activity_main_progress_bar);

            cardStackView = findViewById(R.id.activity_main_card_stack_view);
            cardStackView.setCardEventListener(new CardStackView.CardEventListener() {
                @Override
                public void onCardDragging(float percentX, float percentY) {
                    Log.d("CardStackView", "onCardDragging");
                }

                @Override
                public void onCardSwiped(SwipeDirection direction) {
                    Log.d("CardStackView", "onCardSwiped: " + direction.toString());
                    Log.d("CardStackView", "topIndex: " + cardStackView.getTopIndex());
                    if (cardStackView.getTopIndex() == adapter.getCount() - 5) {
                        Log.d("CardStackView", "Paginate: " + cardStackView.getTopIndex());
                        paginate();
                    }
                }

                @Override
                public void onCardReversed() {
                    Log.d("CardStackView", "onCardReversed");
                }

                @Override
                public void onCardMovedToOrigin() {
                    Log.d("CardStackView", "onCardMovedToOrigin");
                }

                @Override
                public void onCardClicked(int index) {
                    Log.d("CardStackView", "onCardClicked: " + index);
                }
            });
        }

        private void reload() {
            cardStackView.setVisibility(View.GONE);
            progressBar.setVisibility(View.VISIBLE);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    adapter = createEventCardAdapter();
                    cardStackView.setAdapter(adapter);
                    cardStackView.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);
                }
            }, 1000);
        }

        private LinkedList<EventCard> extractRemainingEvents() {
            LinkedList<EventCard> eventList = new LinkedList<>();
            for (int i = cardStackView.getTopIndex(); i < adapter.getCount(); i++) {
                eventList.add(adapter.getItem(i));
            }
            return eventList;
        }

        private void paginate() {
            cardStackView.setPaginationReserved();
            adapter.addAll(createEvents());
            adapter.notifyDataSetChanged();
        }


    }
