package com.MostafaCovied.Mostafacovied.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.MostafaCovied.Mostafacovied.R;
import com.MostafaCovied.Mostafacovied.model.Counter;
import com.MostafaCovied.Mostafacovied.network.Covid_Counter;
import com.MostafaCovied.Mostafacovied.network.RetrofitBuilder;
import com.airbnb.lottie.LottieAnimationView;
import com.razerdp.widget.animatedpieview.AnimatedPieView;
import com.razerdp.widget.animatedpieview.AnimatedPieViewConfig;
import com.razerdp.widget.animatedpieview.data.SimplePieInfo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class checkCityFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    TextView textView_out_stay_carefull;
    AnimatedPieView animatedPieView;
    AnimatedPieViewConfig animatedPieViewConfig;
    Spinner spinner;
    String city;
    LinearLayout linearLayout;
    RelativeLayout relativeLayout_st;
    TextView textView;
    TextView textViewcases_in_world;
    CardView cardView;
    CardView cardView_world;
    TextView textView_red, textView_blue, textView_orange, textView_green, textView_date;
    TextView textView_redin_world, textView_bluein_world, textView_orangein_world, textView_greenin_world, textView_datein_world;
    Covid_Counter covid_counter;
    ArrayList<Integer> count_of_conferme = new ArrayList<>();
    private final static int COUNTER_INDEX = 51;
    Spinner spinner_district_mohafzat;
    LinearLayout linearLayout_for_half_down_body;
    LinearLayout linearLayout_city_out_stay_becarfule_condations;
    TextView textView_tv_of_city;
    LottieAnimationView lottieAnimationView_2;
    LottieAnimationView lottieAnimationView3;
    LottieAnimationView lottieAnimationView1;

    public checkCityFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {// Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_check_city, container, false);
        animatedPieView = view.findViewById(R.id.my_pies);
        linearLayout = view.findViewById(R.id.my_all_p);
        relativeLayout_st = view.findViewById(R.id.r_statcis);
        textView_out_stay_carefull = view.findViewById(R.id.text_for_alarm);
        spinner_district_mohafzat = view.findViewById(R.id.my_spns_district);
        textView_red = view.findViewById(R.id.number_red);
        textView_blue = view.findViewById(R.id.number_blue);
        textView_orange = view.findViewById(R.id.number_orange);
        textView_green = view.findViewById(R.id.number_green);
        textView_date = view.findViewById(R.id.date_to);
        textView = view.findViewById(R.id.cases);
        linearLayout_for_half_down_body = view.findViewById(R.id.test_test);
        textView_tv_of_city = view.findViewById(R.id.counters);
        /////////////////////////
        lottieAnimationView_2 = view.findViewById(R.id.animation_view_2_);
        lottieAnimationView3 = view.findViewById(R.id.animation_view_3);
        lottieAnimationView1 = view.findViewById(R.id.animation_view_);
        textView_redin_world = view.findViewById(R.id.number_redin_world);
        textView_bluein_world = view.findViewById(R.id.number_bluein_world);
        textView_orangein_world = view.findViewById(R.id.number_orangein_world);
        textView_greenin_world = view.findViewById(R.id.number_greenin_world);
        textView_datein_world = view.findViewById(R.id.date_in_world);
        linearLayout_city_out_stay_becarfule_condations = view.findViewById(R.id.city_l);
        textViewcases_in_world = view.findViewById(R.id.cases_in_world);
//////////////////////////////////////////////
        cardView = view.findViewById(R.id.all_card);
        cardView_world = view.findViewById(R.id.all_cardin_world);
        spinner = view.findViewById(R.id.my_spns_);
        covid_counter = RetrofitBuilder.getserves();
        animatedPieViewConfig = new AnimatedPieViewConfig();

        final ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.countries_, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(this);


        count_of_conferme.add(0);//0
        count_of_conferme.add(100);//1 first salm
        count_of_conferme.add(5); //second salm
        count_of_conferme.add(145);//2////nozha
        count_of_conferme.add(74);//3
        count_of_conferme.add(36);//4
        count_of_conferme.add(25);//5
        count_of_conferme.add(10);//5
        count_of_conferme.add(35);//5
        count_of_conferme.add(26);//5
        count_of_conferme.add(75);//5     count_of_conferme.add(145);//2////nozha
        count_of_conferme.add(91);//5
        count_of_conferme.add(76);//5   count_of_conferme.add(74);//3
        count_of_conferme.add(94);//4
        count_of_conferme.add(110);//5
        count_of_conferme.add(64);//3
        count_of_conferme.add(48);//4
        count_of_conferme.add(42);//5
        count_of_conferme.add(19);//5
        count_of_conferme.add(91);//5
        count_of_conferme.add(76);//5   count_of_conferme.add(74);//3
        count_of_conferme.add(94);//4
        count_of_conferme.add(110);//5
        count_of_conferme.add(9);//5
        count_of_conferme.add(40);//5
        count_of_conferme.add(23);//5  count_of_conferme.add(100);//1 first salm
        count_of_conferme.add(10);//5
        count_of_conferme.add(35);//5
        count_of_conferme.add(24);//5   count_of_conferme.add(74);//3
        count_of_conferme.add(14);//4
        count_of_conferme.add(24);//5   count_of_conferme.add(74);//3
        count_of_conferme.add(14);//4
        count_of_conferme.add(27);//5
        count_of_conferme.add(19);//5

        count_of_conferme.add(27);//5
        count_of_conferme.add(19);//5

        count_of_conferme.add(19);//5
        count_of_conferme.add(5); //second salm
        count_of_conferme.add(145);//2////nozha
        count_of_conferme.add(74);//3
        count_of_conferme.add(36);//4
        count_of_conferme.add(25);//5
        count_of_conferme.add(26);//5
        count_of_conferme.add(75);//5     count_of_conferme.add(145);//2////nozha
        count_of_conferme.add(64);//3
        count_of_conferme.add(48);//4
        count_of_conferme.add(42);//5
        count_of_conferme.add(9);//5
        count_of_conferme.add(40);//5
        count_of_conferme.add(23);//5

        covid_counter.getSportNews().enqueue(new Callback<Counter>() {
            @Override
            public void onResponse(Call<Counter> call, Response<Counter> response) {
                if (response.isSuccessful() && response.body() != null) {
                    String totaldeathe = String.valueOf(response.body().getCountries().get(COUNTER_INDEX).getTotalDeaths());
                    if (totaldeathe == null) {
                        return;
                    }
                    String totalconfirmed = String.valueOf(response.body().getCountries().get(COUNTER_INDEX).getTotalConfirmed());
                    String newConfirmed = String.valueOf(response.body().getCountries().get(COUNTER_INDEX).getNewConfirmed());
                    if (Integer.parseInt(newConfirmed) == 0) {
                        textView_blue.setText("709");
                    } else {
                        textView_blue.setText(newConfirmed + "");
                    }
                    String slug = String.valueOf(response.body().getCountries().get(COUNTER_INDEX).getCountry());
                    Toast.makeText(getActivity(), slug + "", Toast.LENGTH_SHORT).show();
                    String totalrecoverd = String.valueOf(response.body().getCountries().get(COUNTER_INDEX).getTotalRecovered());
                    String date = response.body().getCountries().get(COUNTER_INDEX).getDate();
                    textView_red.setText(totaldeathe + "");
                    textView_orange.setText(totalconfirmed + "");
                    textView_green.setText(totalrecoverd + "");
                    textView_date.setText(date + "");
                    animatedPieViewConfig.addData(new SimplePieInfo(Integer.parseInt(totaldeathe), Color.parseColor("#AAFF0000"), "A"));
                    animatedPieViewConfig.addData(new SimplePieInfo(Integer.parseInt(totalconfirmed), Color.parseColor("#fda905"), "B"));
                    animatedPieViewConfig.addData(new SimplePieInfo(Integer.parseInt(totalrecoverd), Color.parseColor("#01fe05"), "C"));
//                    if (Integer.parseInt(newConfirmed) == 0) {
//                        animatedPieViewConfig.addData(new SimplePieInfo(707, Color.parseColor("#FF2196F3"), "F"));
//                    } else {
                        animatedPieViewConfig.addData(new SimplePieInfo(Integer.parseInt(newConfirmed), Color.parseColor("#FF2196F3"), "F"));
                 //   }

                    animatedPieView.applyConfig(animatedPieViewConfig);
                    animatedPieView.animate();
                    animatedPieView.start();
                    String all_Death_in_world = String.valueOf(response.body().getGlobal().getTotalDeaths());
                    textView_redin_world.setText(all_Death_in_world);
                    String all_confarmen_in_world = String.valueOf(response.body().getGlobal().getTotalConfirmed());
                    textView_orangein_world.setText(all_confarmen_in_world);
                    String new_recovred = String.valueOf(response.body().getGlobal().getNewRecovered());
                    textView_greenin_world.setText(new_recovred);
                    String new_cases = String.valueOf(response.body().getGlobal().getNewConfirmed());

                    textView_bluein_world.setText(new_cases);


                    textView_datein_world.setText(date);
                }

            }

            @Override
            public void onFailure(Call<Counter> call, Throwable t) {
                Log.e("tag", "tag" + t.getMessage());
            }
        });
        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        city = parent.getItemAtPosition(position).toString();
        if (parent.getItemAtPosition(position).equals("choose your city") || parent.getItemAtPosition(position).equals("اختار محافظتك")) {
//            relativeLayout_st.setVisibility(View.VISIBLE);
//            linearLayout.setVisibility(View.VISIBLE);
//            textView.setVisibility(View.VISIBLE);
//            cardView.setVisibility(View.VISIBLE);
//            cardView_world.setVisibility(View.VISIBLE);
            linearLayout_for_half_down_body.setVisibility(View.VISIBLE);
            spinner_district_mohafzat.setVisibility(View.GONE);
            linearLayout_city_out_stay_becarfule_condations.setVisibility(View.GONE);
        } else if (parent.getItemAtPosition(position).equals("Cairo") || parent.getItemAtPosition(position).equals("القاهرة") && parent.getSelectedItemPosition() >= 0) {
            spinner_district_mohafzat.setVisibility(View.VISIBLE);
            //  Toast.makeText(getActivity(), "stay home", Toast.LENGTH_SHORT).show();
            //  Toast.makeText(getActivity(), count.get(position) + "", Toast.LENGTH_SHORT).show();
            final ArrayAdapter<CharSequence> arrayAdapter2 = ArrayAdapter.createFromResource(getActivity(), R.array.cairo_district, android.R.layout.simple_spinner_item);
            arrayAdapter2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            spinner_district_mohafzat.setAdapter(arrayAdapter2);
            linearLayout_for_half_down_body.setVisibility(View.GONE);
//            Toast.makeText(getActivity(), spinner_district.getItemIdAtPosition(position)+"", Toast.LENGTH_SHORT).show();
//            Toast.makeText(getActivity(), spinner_district.getCount()+"", Toast.LENGTH_SHORT).show();
//            Toast.makeText(getActivity(), spinner_district.getSelectedItem()+"", Toast.LENGTH_SHORT).show();
            spinner_district_mohafzat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    //Toast.makeText(getActivity(), parent.getSelectedItem()+"", Toast.LENGTH_SHORT).show();
                    if (position >= 0 && count_of_conferme.get(position) >= 71) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.GONE);
                        lottieAnimationView3.setVisibility(View.GONE);
                        lottieAnimationView1.setVisibility(View.VISIBLE);
                        textView_out_stay_carefull.setText(getString(R.string.please_stay_home));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    } else if (position >= 0 && count_of_conferme.get(position) <= 70 && count_of_conferme.get(position) >= 30) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.VISIBLE);
                        lottieAnimationView3.setVisibility(View.GONE);
                        lottieAnimationView1.setVisibility(View.GONE);
                        textView_out_stay_carefull.setText(getString(R.string.please_be_carfull));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    } else if (position >= 0 && count_of_conferme.get(position) <= 29 && count_of_conferme.get(position) >= 1) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.GONE);
                        lottieAnimationView3.setVisibility(View.VISIBLE);
                        lottieAnimationView1.setVisibility(View.GONE);
                        textView_out_stay_carefull.setText(getString(R.string.please_go_out));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
            //////////////////////////////////////////////////////////////////////////////////////////////////
        } else if (parent.getItemAtPosition(position).equals("Alexandria") || parent.getItemAtPosition(position).equals("الاسكندرية") && parent.getSelectedItemPosition() >= 0) {
//            relativeLayout_st.setVisibility(View.GONE);
//            textView.setVisibility(View.GONE);
//            cardView.setVisibility(View.GONE);
            linearLayout_for_half_down_body.setVisibility(View.GONE);
            // Toast.makeText(getActivity(), "go out", Toast.LENGTH_SHORT).show();
            // Toast.makeText(getActivity(), count_of_conferme.get(position) + "", Toast.LENGTH_SHORT).show();
            final ArrayAdapter<CharSequence> arrayAdapter2 = ArrayAdapter.createFromResource(getActivity(), R.array.Alexandria, android.R.layout.simple_spinner_item);
            arrayAdapter2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            spinner_district_mohafzat.setAdapter(arrayAdapter2);
            spinner_district_mohafzat.setVisibility(View.VISIBLE);
            spinner_district_mohafzat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position >= 0 && count_of_conferme.get(position) >= 71) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.GONE);
                        lottieAnimationView3.setVisibility(View.GONE);
                        lottieAnimationView1.setVisibility(View.VISIBLE);
                        textView_out_stay_carefull.setText(getString(R.string.please_stay_home));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    } else if (position >= 0 && count_of_conferme.get(position) <= 70 && count_of_conferme.get(position) >= 30) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.VISIBLE);
                        lottieAnimationView3.setVisibility(View.GONE);
                        lottieAnimationView1.setVisibility(View.GONE);
                        textView_out_stay_carefull.setText(getString(R.string.please_be_carfull));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    } else if (position >= 0 && count_of_conferme.get(position) <= 29 && count_of_conferme.get(position) >= 1) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.GONE);
                        lottieAnimationView3.setVisibility(View.VISIBLE);
                        lottieAnimationView1.setVisibility(View.GONE);
                        textView_out_stay_carefull.setText(getString(R.string.please_go_out));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        } else if (parent.getSelectedItemPosition() >= 0 && parent.getItemAtPosition(position).equals("Aswan") || parent.getItemAtPosition(position).equals("اسوان") && parent.getSelectedItemPosition() >= 0) {
//            relativeLayout_st.setVisibility(View.GONE);
//            textView.setVisibility(View.GONE);
//            cardView.setVisibility(View.GONE);
            linearLayout_for_half_down_body.setVisibility(View.GONE);
            // Toast.makeText(getActivity(), "be carefully", Toast.LENGTH_SHORT).show();
            // Toast.makeText(getActivity(), count_of_conferme.get(position) + "", Toast.LENGTH_SHORT).show();
            final ArrayAdapter<CharSequence> arrayAdapter2 = ArrayAdapter.createFromResource(getActivity(), R.array.Aswan, android.R.layout.simple_spinner_item);
            arrayAdapter2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            spinner_district_mohafzat.setAdapter(arrayAdapter2);
            spinner_district_mohafzat.setVisibility(View.VISIBLE);
            spinner_district_mohafzat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position >= 0 && count_of_conferme.get(position) >= 71) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.GONE);
                        lottieAnimationView3.setVisibility(View.GONE);
                        lottieAnimationView1.setVisibility(View.VISIBLE);
                        textView_out_stay_carefull.setText(getString(R.string.please_stay_home));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    } else if (position >= 0 && count_of_conferme.get(position) <= 70 && count_of_conferme.get(position) >= 30) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.VISIBLE);
                        lottieAnimationView3.setVisibility(View.GONE);
                        lottieAnimationView1.setVisibility(View.GONE);
                        textView_out_stay_carefull.setText(getString(R.string.please_be_carfull));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    } else if (position >= 0 && count_of_conferme.get(position) <= 29 && count_of_conferme.get(position) >= 1) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.GONE);
                        lottieAnimationView3.setVisibility(View.VISIBLE);
                        lottieAnimationView1.setVisibility(View.GONE);
                        textView_out_stay_carefull.setText(getString(R.string.please_go_out));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
        } else if (parent.getSelectedItemPosition() >= 0 && parent.getItemAtPosition(position).equals("Asyut") ||
                parent.getItemAtPosition(position).equals("اسيوط") && parent.getSelectedItemPosition() >= 0) {
//            relativeLayout_st.setVisibility(View.GONE);
//            textView.setVisibility(View.GONE);
//            cardView.setVisibility(View.GONE);
            linearLayout_for_half_down_body.setVisibility(View.GONE);
            // Toast.makeText(getActivity(), "be carefully", Toast.LENGTH_SHORT).show();
            // Toast.makeText(getActivity(), count_of_conferme.get(position) + "", Toast.LENGTH_SHORT).show();
            final ArrayAdapter<CharSequence> arrayAdapter2 = ArrayAdapter.createFromResource(getActivity(), R.array.Asyut, android.R.layout.simple_spinner_item);
            arrayAdapter2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            spinner_district_mohafzat.setAdapter(arrayAdapter2);
            spinner_district_mohafzat.setVisibility(View.VISIBLE);
            spinner_district_mohafzat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position >= 0 && count_of_conferme.get(position) >= 71) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.GONE);
                        lottieAnimationView3.setVisibility(View.GONE);
                        lottieAnimationView1.setVisibility(View.VISIBLE);
                        textView_out_stay_carefull.setText(getString(R.string.please_stay_home));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    } else if (position >= 0 && count_of_conferme.get(position) <= 70 && count_of_conferme.get(position) >= 30) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.VISIBLE);
                        lottieAnimationView3.setVisibility(View.GONE);
                        lottieAnimationView1.setVisibility(View.GONE);
                        textView_out_stay_carefull.setText(getString(R.string.please_be_carfull));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    } else if (position >= 0 && count_of_conferme.get(position) <= 29 && count_of_conferme.get(position) >= 1) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.GONE);
                        lottieAnimationView3.setVisibility(View.VISIBLE);
                        lottieAnimationView1.setVisibility(View.GONE);
                        textView_out_stay_carefull.setText(getString(R.string.please_go_out));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
        } else if (parent.getSelectedItemPosition() >= 0 && parent.getItemAtPosition(position).equals("Beheira") ||
                parent.getItemAtPosition(position).equals("البحيرة") && parent.getSelectedItemPosition() >= 0) {
//            relativeLayout_st.setVisibility(View.GONE);
//            textView.setVisibility(View.GONE);
//            cardView.setVisibility(View.GONE);
            linearLayout_for_half_down_body.setVisibility(View.GONE);
            // Toast.makeText(getActivity(), "be carefully", Toast.LENGTH_SHORT).show();
            // Toast.makeText(getActivity(), count_of_conferme.get(position) + "", Toast.LENGTH_SHORT).show();
            final ArrayAdapter<CharSequence> arrayAdapter2 = ArrayAdapter.createFromResource(getActivity(), R.array.Beheira, android.R.layout.simple_spinner_item);
            arrayAdapter2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            spinner_district_mohafzat.setAdapter(arrayAdapter2);
            spinner_district_mohafzat.setVisibility(View.VISIBLE);
            spinner_district_mohafzat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position >= 0 && count_of_conferme.get(position) >= 71) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.GONE);
                        lottieAnimationView3.setVisibility(View.GONE);
                        lottieAnimationView1.setVisibility(View.VISIBLE);
                        textView_out_stay_carefull.setText(getString(R.string.please_stay_home));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    } else if (position >= 0 && count_of_conferme.get(position) <= 70 && count_of_conferme.get(position) >= 30) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.VISIBLE);
                        lottieAnimationView3.setVisibility(View.GONE);
                        lottieAnimationView1.setVisibility(View.GONE);
                        textView_out_stay_carefull.setText(getString(R.string.please_be_carfull));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    } else if (position >= 0 && count_of_conferme.get(position) <= 29 && count_of_conferme.get(position) >= 1) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.GONE);
                        lottieAnimationView3.setVisibility(View.VISIBLE);
                        lottieAnimationView1.setVisibility(View.GONE);
                        textView_out_stay_carefull.setText(getString(R.string.please_go_out));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
        } else if (parent.getSelectedItemPosition() >= 0 && parent.getItemAtPosition(position).equals("Beni Suef") || parent.getItemAtPosition(position).equals("بني سويف") && parent.getSelectedItemPosition() >= 0) {
//            relativeLayout_st.setVisibility(View.GONE);
//            textView.setVisibility(View.GONE);
//            cardView.setVisibility(View.GONE);
            linearLayout_for_half_down_body.setVisibility(View.GONE);
            // Toast.makeText(getActivity(), "be carefully", Toast.LENGTH_SHORT).show();
            // Toast.makeText(getActivity(), count_of_conferme.get(position) + "", Toast.LENGTH_SHORT).show();
            final ArrayAdapter<CharSequence> arrayAdapter2 = ArrayAdapter.createFromResource(getActivity(), R.array.Beni_Suef, android.R.layout.simple_spinner_item);
            arrayAdapter2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            spinner_district_mohafzat.setAdapter(arrayAdapter2);
            spinner_district_mohafzat.setVisibility(View.VISIBLE);
            spinner_district_mohafzat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position >= 0 && count_of_conferme.get(position) >= 71) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.GONE);
                        lottieAnimationView3.setVisibility(View.GONE);
                        lottieAnimationView1.setVisibility(View.VISIBLE);
                        textView_out_stay_carefull.setText(getString(R.string.please_stay_home));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    } else if (position >= 0 && count_of_conferme.get(position) <= 70 && count_of_conferme.get(position) >= 30) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.VISIBLE);
                        lottieAnimationView3.setVisibility(View.GONE);
                        lottieAnimationView1.setVisibility(View.GONE);
                        textView_out_stay_carefull.setText(getString(R.string.please_be_carfull));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    } else if (position >= 0 && count_of_conferme.get(position) <= 29 && count_of_conferme.get(position) >= 1) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.GONE);
                        lottieAnimationView3.setVisibility(View.VISIBLE);
                        lottieAnimationView1.setVisibility(View.GONE);
                        textView_out_stay_carefull.setText(getString(R.string.please_go_out));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
        } else if (parent.getSelectedItemPosition() >= 0 && parent.getItemAtPosition(position).equals("Dakahlia") || parent.getItemAtPosition(position).equals("الدقهلية") && parent.getSelectedItemPosition() >= 0) {
//            relativeLayout_st.setVisibility(View.GONE);
//            textView.setVisibility(View.GONE);
//            cardView.setVisibility(View.GONE);
            linearLayout_for_half_down_body.setVisibility(View.GONE);
            // Toast.makeText(getActivity(), "be carefully", Toast.LENGTH_SHORT).show();
            // Toast.makeText(getActivity(), count_of_conferme.get(position) + "", Toast.LENGTH_SHORT).show();
            final ArrayAdapter<CharSequence> arrayAdapter3 = ArrayAdapter.createFromResource(getActivity(), R.array.Dakahlia, android.R.layout.simple_spinner_item);
            arrayAdapter3.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            spinner_district_mohafzat.setAdapter(arrayAdapter3);
            spinner_district_mohafzat.setVisibility(View.VISIBLE);
            spinner_district_mohafzat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position >= 0 && count_of_conferme.get(position) >= 71) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.GONE);
                        lottieAnimationView3.setVisibility(View.GONE);
                        lottieAnimationView1.setVisibility(View.VISIBLE);
                        textView_out_stay_carefull.setText(getString(R.string.please_stay_home));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    } else if (position >= 0 && count_of_conferme.get(position) <= 70 && count_of_conferme.get(position) >= 30) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.VISIBLE);
                        lottieAnimationView3.setVisibility(View.GONE);
                        lottieAnimationView1.setVisibility(View.GONE);
                        textView_out_stay_carefull.setText(getString(R.string.please_be_carfull));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    } else if (position >= 0 && count_of_conferme.get(position) <= 29 && count_of_conferme.get(position) >= 1) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.GONE);
                        lottieAnimationView3.setVisibility(View.VISIBLE);
                        lottieAnimationView1.setVisibility(View.GONE);
                        textView_out_stay_carefull.setText(getString(R.string.please_go_out));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
        } else if (parent.getSelectedItemPosition() >= 0 && parent.getItemAtPosition(position).equals("Damietta") || parent.getItemAtPosition(position).equals("دمياط") && parent.getSelectedItemPosition() >= 0) {
//            relativeLayout_st.setVisibility(View.GONE);
//            textView.setVisibility(View.GONE);
//            cardView.setVisibility(View.GONE);
            linearLayout_for_half_down_body.setVisibility(View.GONE);
            // Toast.makeText(getActivity(), "be carefully", Toast.LENGTH_SHORT).show();
            // Toast.makeText(getActivity(), count_of_conferme.get(position) + "", Toast.LENGTH_SHORT).show();
            final ArrayAdapter<CharSequence> arrayAdapter3 = ArrayAdapter.createFromResource(getActivity(), R.array.Damietta, android.R.layout.simple_spinner_item);
            arrayAdapter3.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            spinner_district_mohafzat.setAdapter(arrayAdapter3);
            spinner_district_mohafzat.setVisibility(View.VISIBLE);
            spinner_district_mohafzat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position >= 0 && count_of_conferme.get(position) >= 71) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.GONE);
                        lottieAnimationView3.setVisibility(View.GONE);
                        lottieAnimationView1.setVisibility(View.VISIBLE);
                        textView_out_stay_carefull.setText(getString(R.string.please_stay_home));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    } else if (position >= 0 && count_of_conferme.get(position) <= 70 && count_of_conferme.get(position) >= 30) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.VISIBLE);
                        lottieAnimationView3.setVisibility(View.GONE);
                        lottieAnimationView1.setVisibility(View.GONE);
                        textView_out_stay_carefull.setText(getString(R.string.please_be_carfull));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    } else if (position >= 0 && count_of_conferme.get(position) <= 29 && count_of_conferme.get(position) >= 1) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.GONE);
                        lottieAnimationView3.setVisibility(View.VISIBLE);
                        lottieAnimationView1.setVisibility(View.GONE);
                        textView_out_stay_carefull.setText(getString(R.string.please_go_out));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
        } else if (parent.getSelectedItemPosition() >= 0 && parent.getItemAtPosition(position).equals("Faiyum") || parent.getItemAtPosition(position).equals("الفيوم") && parent.getSelectedItemPosition() >= 0) {
//            relativeLayout_st.setVisibility(View.GONE);
//            textView.setVisibility(View.GONE);
//            cardView.setVisibility(View.GONE);
            linearLayout_for_half_down_body.setVisibility(View.GONE);
            // Toast.makeText(getActivity(), "be carefully", Toast.LENGTH_SHORT).show();
            // Toast.makeText(getActivity(), count_of_conferme.get(position) + "", Toast.LENGTH_SHORT).show();
            final ArrayAdapter<CharSequence> arrayAdapter3 = ArrayAdapter.createFromResource(getActivity(), R.array.Faiyum, android.R.layout.simple_spinner_item);
            arrayAdapter3.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            spinner_district_mohafzat.setAdapter(arrayAdapter3);
            spinner_district_mohafzat.setVisibility(View.VISIBLE);
            spinner_district_mohafzat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position >= 0 && count_of_conferme.get(position) >= 71) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.GONE);
                        lottieAnimationView3.setVisibility(View.GONE);
                        lottieAnimationView1.setVisibility(View.VISIBLE);
                        textView_out_stay_carefull.setText(getString(R.string.please_stay_home));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    } else if (position >= 0 && count_of_conferme.get(position) <= 70 && count_of_conferme.get(position) >= 30) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.VISIBLE);
                        lottieAnimationView3.setVisibility(View.GONE);
                        lottieAnimationView1.setVisibility(View.GONE);
                        textView_out_stay_carefull.setText(getString(R.string.please_be_carfull));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    } else if (position >= 0 && count_of_conferme.get(position) <= 29 && count_of_conferme.get(position) >= 1) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.GONE);
                        lottieAnimationView3.setVisibility(View.VISIBLE);
                        lottieAnimationView1.setVisibility(View.GONE);
                        textView_out_stay_carefull.setText(getString(R.string.please_go_out));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
        } else if (parent.getSelectedItemPosition() >= 0 && parent.getItemAtPosition(position).equals("Gharbi") || parent.getItemAtPosition(position).equals("الغربية") && parent.getSelectedItemPosition() >= 0) {
//            relativeLayout_st.setVisibility(View.GONE);
//            textView.setVisibility(View.GONE);
//            cardView.setVisibility(View.GONE);
            linearLayout_for_half_down_body.setVisibility(View.GONE);
            // Toast.makeText(getActivity(), "be carefully", Toast.LENGTH_SHORT).show();
            // Toast.makeText(getActivity(), count_of_conferme.get(position) + "", Toast.LENGTH_SHORT).show();
            final ArrayAdapter<CharSequence> arrayAdapter3 = ArrayAdapter.createFromResource(getActivity(), R.array.Gharbi, android.R.layout.simple_spinner_item);
            arrayAdapter3.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            spinner_district_mohafzat.setAdapter(arrayAdapter3);
            spinner_district_mohafzat.setVisibility(View.VISIBLE);
            spinner_district_mohafzat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position >= 0 && count_of_conferme.get(position) >= 71) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.GONE);
                        lottieAnimationView3.setVisibility(View.GONE);
                        lottieAnimationView1.setVisibility(View.VISIBLE);
                        textView_out_stay_carefull.setText(getString(R.string.please_stay_home));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    } else if (position >= 0 && count_of_conferme.get(position) <= 70 && count_of_conferme.get(position) >= 30) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.VISIBLE);
                        lottieAnimationView3.setVisibility(View.GONE);
                        lottieAnimationView1.setVisibility(View.GONE);
                        textView_out_stay_carefull.setText(getString(R.string.please_be_carfull));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    } else if (position >= 0 && count_of_conferme.get(position) <= 29 && count_of_conferme.get(position) >= 1) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.GONE);
                        lottieAnimationView3.setVisibility(View.VISIBLE);
                        lottieAnimationView1.setVisibility(View.GONE);
                        textView_out_stay_carefull.setText(getString(R.string.please_go_out));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
        } else if (parent.getSelectedItemPosition() >= 0 && parent.getItemAtPosition(position).equals("Giza") || parent.getItemAtPosition(position).equals("الجيزة") && parent.getSelectedItemPosition() >= 0) {
//            relativeLayout_st.setVisibility(View.GONE);
//            textView.setVisibility(View.GONE);
//            cardView.setVisibility(View.GONE);
            linearLayout_for_half_down_body.setVisibility(View.GONE);
            // Toast.makeText(getActivity(), "be carefully", Toast.LENGTH_SHORT).show();
            // Toast.makeText(getActivity(), count_of_conferme.get(position) + "", Toast.LENGTH_SHORT).show();
            final ArrayAdapter<CharSequence> arrayAdapter3 = ArrayAdapter.createFromResource(getActivity(), R.array.Giza, android.R.layout.simple_spinner_item);
            arrayAdapter3.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            spinner_district_mohafzat.setAdapter(arrayAdapter3);
            spinner_district_mohafzat.setVisibility(View.VISIBLE);
            spinner_district_mohafzat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position >= 0 && count_of_conferme.get(position) >= 71) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.GONE);
                        lottieAnimationView3.setVisibility(View.GONE);
                        lottieAnimationView1.setVisibility(View.VISIBLE);
                        textView_out_stay_carefull.setText(getString(R.string.please_stay_home));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    } else if (position >= 0 && count_of_conferme.get(position) <= 70 && count_of_conferme.get(position) >= 30) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.VISIBLE);
                        lottieAnimationView3.setVisibility(View.GONE);
                        lottieAnimationView1.setVisibility(View.GONE);
                        textView_out_stay_carefull.setText(getString(R.string.please_be_carfull));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    } else if (position >= 0 && count_of_conferme.get(position) <= 29 && count_of_conferme.get(position) >= 1) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.GONE);
                        lottieAnimationView3.setVisibility(View.VISIBLE);
                        lottieAnimationView1.setVisibility(View.GONE);
                        textView_out_stay_carefull.setText(getString(R.string.please_go_out));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
        } else if (parent.getSelectedItemPosition() >= 0 && parent.getItemAtPosition(position).equals("Ismailia") || parent.getItemAtPosition(position).equals("الاسماعلية") && parent.getSelectedItemPosition() >= 0) {
//            relativeLayout_st.setVisibility(View.GONE);
//            textView.setVisibility(View.GONE);
//            cardView.setVisibility(View.GONE);
            linearLayout_for_half_down_body.setVisibility(View.GONE);
            // Toast.makeText(getActivity(), "be carefully", Toast.LENGTH_SHORT).show();
            // Toast.makeText(getActivity(), count_of_conferme.get(position) + "", Toast.LENGTH_SHORT).show();
            final ArrayAdapter<CharSequence> arrayAdapter3 = ArrayAdapter.createFromResource(getActivity(), R.array.Ismailia, android.R.layout.simple_spinner_item);
            arrayAdapter3.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            spinner_district_mohafzat.setAdapter(arrayAdapter3);
            spinner_district_mohafzat.setVisibility(View.VISIBLE);
            spinner_district_mohafzat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position >= 0 && count_of_conferme.get(position) >= 71) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.GONE);
                        lottieAnimationView3.setVisibility(View.GONE);
                        lottieAnimationView1.setVisibility(View.VISIBLE);
                        textView_out_stay_carefull.setText(getString(R.string.please_stay_home));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    } else if (position >= 0 && count_of_conferme.get(position) <= 70 && count_of_conferme.get(position) >= 30) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.VISIBLE);
                        lottieAnimationView3.setVisibility(View.GONE);
                        lottieAnimationView1.setVisibility(View.GONE);
                        textView_out_stay_carefull.setText(getString(R.string.please_be_carfull));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    } else if (position >= 0 && count_of_conferme.get(position) <= 29 && count_of_conferme.get(position) >= 1) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.GONE);
                        lottieAnimationView3.setVisibility(View.VISIBLE);
                        lottieAnimationView1.setVisibility(View.GONE);
                        textView_out_stay_carefull.setText(getString(R.string.please_go_out));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
        } else if (parent.getSelectedItemPosition() >= 0 && parent.getItemAtPosition(position).equals("Kafr El Sheikh") || parent.getItemAtPosition(position).equals("كفر الشيخ") && parent.getSelectedItemPosition() >= 0) {
//            relativeLayout_st.setVisibility(View.GONE);
//            textView.setVisibility(View.GONE);
//            cardView.setVisibility(View.GONE);
            linearLayout_for_half_down_body.setVisibility(View.GONE);
            // Toast.makeText(getActivity(), "be carefully", Toast.LENGTH_SHORT).show();
            // Toast.makeText(getActivity(), count_of_conferme.get(position) + "", Toast.LENGTH_SHORT).show();
            final ArrayAdapter<CharSequence> arrayAdapter3 = ArrayAdapter.createFromResource(getActivity(), R.array.KafrElSheikh, android.R.layout.simple_spinner_item);
            arrayAdapter3.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            spinner_district_mohafzat.setAdapter(arrayAdapter3);
            spinner_district_mohafzat.setVisibility(View.VISIBLE);
            spinner_district_mohafzat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position >= 0 && count_of_conferme.get(position) >= 71) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.GONE);
                        lottieAnimationView3.setVisibility(View.GONE);
                        lottieAnimationView1.setVisibility(View.VISIBLE);
                        textView_out_stay_carefull.setText(getString(R.string.please_stay_home));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    } else if (position >= 0 && count_of_conferme.get(position) <= 70 && count_of_conferme.get(position) >= 30) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.VISIBLE);
                        lottieAnimationView3.setVisibility(View.GONE);
                        lottieAnimationView1.setVisibility(View.GONE);
                        textView_out_stay_carefull.setText(getString(R.string.please_be_carfull));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    } else if (position >= 0 && count_of_conferme.get(position) <= 29 && count_of_conferme.get(position) >= 1) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.GONE);
                        lottieAnimationView3.setVisibility(View.VISIBLE);
                        lottieAnimationView1.setVisibility(View.GONE);
                        textView_out_stay_carefull.setText(getString(R.string.please_go_out));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
        } else if (parent.getSelectedItemPosition() >= 0 && parent.getItemAtPosition(position).equals("Luxor") || parent.getItemAtPosition(position).equals("الاقصر") && parent.getSelectedItemPosition() >= 0) {
//            relativeLayout_st.setVisibility(View.GONE);
//            textView.setVisibility(View.GONE);
//            cardView.setVisibility(View.GONE);
            linearLayout_for_half_down_body.setVisibility(View.GONE);
            // Toast.makeText(getActivity(), "be carefully", Toast.LENGTH_SHORT).show();
            // Toast.makeText(getActivity(), count_of_conferme.get(position) + "", Toast.LENGTH_SHORT).show();
            final ArrayAdapter<CharSequence> arrayAdapter3 = ArrayAdapter.createFromResource(getActivity(), R.array.Luxor, android.R.layout.simple_spinner_item);
            arrayAdapter3.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            spinner_district_mohafzat.setAdapter(arrayAdapter3);
            spinner_district_mohafzat.setVisibility(View.VISIBLE);
            spinner_district_mohafzat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position >= 0 && count_of_conferme.get(position) >= 71) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.GONE);
                        lottieAnimationView3.setVisibility(View.GONE);
                        lottieAnimationView1.setVisibility(View.VISIBLE);
                        textView_out_stay_carefull.setText(getString(R.string.please_stay_home));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    } else if (position >= 0 && count_of_conferme.get(position) <= 70 && count_of_conferme.get(position) >= 30) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.VISIBLE);
                        lottieAnimationView3.setVisibility(View.GONE);
                        lottieAnimationView1.setVisibility(View.GONE);
                        textView_out_stay_carefull.setText(getString(R.string.please_be_carfull));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    } else if (position >= 0 && count_of_conferme.get(position) <= 29 && count_of_conferme.get(position) >= 1) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.GONE);
                        lottieAnimationView3.setVisibility(View.VISIBLE);
                        lottieAnimationView1.setVisibility(View.GONE);
                        textView_out_stay_carefull.setText(getString(R.string.please_go_out));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
        } else if (parent.getSelectedItemPosition() >= 0 && parent.getItemAtPosition(position).equals("Matruh") || parent.getItemAtPosition(position).equals("مطروح") && parent.getSelectedItemPosition() >= 0) {
//            relativeLayout_st.setVisibility(View.GONE);
//            textView.setVisibility(View.GONE);
//            cardView.setVisibility(View.GONE);
            linearLayout_for_half_down_body.setVisibility(View.GONE);
            // Toast.makeText(getActivity(), "be carefully", Toast.LENGTH_SHORT).show();
            // Toast.makeText(getActivity(), count_of_conferme.get(position) + "", Toast.LENGTH_SHORT).show();
            final ArrayAdapter<CharSequence> arrayAdapter3 = ArrayAdapter.createFromResource(getActivity(), R.array.Matruh, android.R.layout.simple_spinner_item);
            arrayAdapter3.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            spinner_district_mohafzat.setAdapter(arrayAdapter3);
            spinner_district_mohafzat.setVisibility(View.VISIBLE);
            spinner_district_mohafzat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position >= 0 && count_of_conferme.get(position) >= 71) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.GONE);
                        lottieAnimationView3.setVisibility(View.GONE);
                        lottieAnimationView1.setVisibility(View.VISIBLE);
                        textView_out_stay_carefull.setText(getString(R.string.please_stay_home));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    } else if (position >= 0 && count_of_conferme.get(position) <= 70 && count_of_conferme.get(position) >= 3) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.VISIBLE);
                        lottieAnimationView3.setVisibility(View.GONE);
                        lottieAnimationView1.setVisibility(View.GONE);
                        textView_out_stay_carefull.setText(getString(R.string.please_be_carfull));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    } else if (position >= 0 && count_of_conferme.get(position) <= 29 && count_of_conferme.get(position) >= 1) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.GONE);
                        lottieAnimationView3.setVisibility(View.VISIBLE);
                        lottieAnimationView1.setVisibility(View.GONE);
                        textView_out_stay_carefull.setText(getString(R.string.please_go_out));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
        } else if (parent.getSelectedItemPosition() >= 0 && parent.getItemAtPosition(position).equals("Minya") || parent.getItemAtPosition(position).equals("المنيا") && parent.getSelectedItemPosition() >= 0) {
//            relativeLayout_st.setVisibility(View.GONE);
//            textView.setVisibility(View.GONE);
//            cardView.setVisibility(View.GONE);
            linearLayout_for_half_down_body.setVisibility(View.GONE);
            // Toast.makeText(getActivity(), "be carefully", Toast.LENGTH_SHORT).show();
            // Toast.makeText(getActivity(), count_of_conferme.get(position) + "", Toast.LENGTH_SHORT).show();
            final ArrayAdapter<CharSequence> arrayAdapter3 = ArrayAdapter.createFromResource(getActivity(), R.array.Minya, android.R.layout.simple_spinner_item);
            arrayAdapter3.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            spinner_district_mohafzat.setAdapter(arrayAdapter3);
            spinner_district_mohafzat.setVisibility(View.VISIBLE);
            spinner_district_mohafzat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position >= 0 && count_of_conferme.get(position) >= 71) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.GONE);
                        lottieAnimationView3.setVisibility(View.GONE);
                        lottieAnimationView1.setVisibility(View.VISIBLE);
                        textView_out_stay_carefull.setText(getString(R.string.please_stay_home));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    } else if (position >= 0 && count_of_conferme.get(position) <= 70 && count_of_conferme.get(position) >= 30) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.VISIBLE);
                        lottieAnimationView3.setVisibility(View.GONE);
                        lottieAnimationView1.setVisibility(View.GONE);
                        textView_out_stay_carefull.setText(getString(R.string.please_be_carfull));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    } else if (position >= 0 && count_of_conferme.get(position) <= 29 && count_of_conferme.get(position) >= 1) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.GONE);
                        lottieAnimationView3.setVisibility(View.VISIBLE);
                        lottieAnimationView1.setVisibility(View.GONE);
                        textView_out_stay_carefull.setText(getString(R.string.please_go_out));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
        } else if (parent.getSelectedItemPosition() >= 0 && parent.getItemAtPosition(position).equals("Monufia") || parent.getItemAtPosition(position).equals("المنوفية") && parent.getSelectedItemPosition() >= 0) {
//            relativeLayout_st.setVisibility(View.GONE);
//            textView.setVisibility(View.GONE);
//            cardView.setVisibility(View.GONE);
            linearLayout_for_half_down_body.setVisibility(View.GONE);
            // Toast.makeText(getActivity(), "be carefully", Toast.LENGTH_SHORT).show();
            // Toast.makeText(getActivity(), count_of_conferme.get(position) + "", Toast.LENGTH_SHORT).show();
            final ArrayAdapter<CharSequence> arrayAdapter3 = ArrayAdapter.createFromResource(getActivity(), R.array.Monufia, android.R.layout.simple_spinner_item);
            arrayAdapter3.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            spinner_district_mohafzat.setAdapter(arrayAdapter3);
            spinner_district_mohafzat.setVisibility(View.VISIBLE);
            spinner_district_mohafzat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position >= 0 && count_of_conferme.get(position) >= 71) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.GONE);
                        lottieAnimationView3.setVisibility(View.GONE);
                        lottieAnimationView1.setVisibility(View.VISIBLE);
                        textView_out_stay_carefull.setText(getString(R.string.please_stay_home));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    } else if (position >= 0 && count_of_conferme.get(position) <= 70 && count_of_conferme.get(position) >= 30) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.VISIBLE);
                        lottieAnimationView3.setVisibility(View.GONE);
                        lottieAnimationView1.setVisibility(View.GONE);
                        textView_out_stay_carefull.setText(getString(R.string.please_be_carfull));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    } else if (position >= 0 && count_of_conferme.get(position) <= 29 && count_of_conferme.get(position) >= 1) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.GONE);
                        lottieAnimationView3.setVisibility(View.VISIBLE);
                        lottieAnimationView1.setVisibility(View.GONE);
                        textView_out_stay_carefull.setText(getString(R.string.please_go_out));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
        } else if (parent.getSelectedItemPosition() >= 0 && parent.getItemAtPosition(position).equals("North Sinai") || parent.getItemAtPosition(position).equals("شمال سينا") && parent.getSelectedItemPosition() >= 0) {
//            relativeLayout_st.setVisibility(View.GONE);
//            textView.setVisibility(View.GONE);
//            cardView.setVisibility(View.GONE);
            linearLayout_for_half_down_body.setVisibility(View.GONE);
            // Toast.makeText(getActivity(), "be carefully", Toast.LENGTH_SHORT).show();
            // Toast.makeText(getActivity(), count_of_conferme.get(position) + "", Toast.LENGTH_SHORT).show();
            final ArrayAdapter<CharSequence> arrayAdapter3 = ArrayAdapter.createFromResource(getActivity(), R.array.NorthSinai, android.R.layout.simple_spinner_item);
            arrayAdapter3.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            spinner_district_mohafzat.setAdapter(arrayAdapter3);
            spinner_district_mohafzat.setVisibility(View.VISIBLE);
            spinner_district_mohafzat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position >= 0 && count_of_conferme.get(position) >= 71) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.GONE);
                        lottieAnimationView3.setVisibility(View.GONE);
                        lottieAnimationView1.setVisibility(View.VISIBLE);
                        textView_out_stay_carefull.setText(getString(R.string.please_stay_home));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    } else if (position >= 0 && count_of_conferme.get(position) <= 70 && count_of_conferme.get(position) >= 30) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.VISIBLE);
                        lottieAnimationView3.setVisibility(View.GONE);
                        lottieAnimationView1.setVisibility(View.GONE);
                        textView_out_stay_carefull.setText(getString(R.string.please_be_carfull));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    } else if (position >= 0 && count_of_conferme.get(position) <= 29 && count_of_conferme.get(position) >= 1) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.GONE);
                        lottieAnimationView3.setVisibility(View.VISIBLE);
                        lottieAnimationView1.setVisibility(View.GONE);
                        textView_out_stay_carefull.setText(getString(R.string.please_go_out));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
        } else if (parent.getSelectedItemPosition() >= 0 && parent.getItemAtPosition(position).equals("Port Said") || parent.getItemAtPosition(position).equals("بورسعيد") && parent.getSelectedItemPosition() >= 0) {
//            relativeLayout_st.setVisibility(View.GONE);
//            textView.setVisibility(View.GONE);
//            cardView.setVisibility(View.GONE);
            linearLayout_for_half_down_body.setVisibility(View.GONE);
            // Toast.makeText(getActivity(), "be carefully", Toast.LENGTH_SHORT).show();
            // Toast.makeText(getActivity(), count_of_conferme.get(position) + "", Toast.LENGTH_SHORT).show();
            final ArrayAdapter<CharSequence> arrayAdapter3 = ArrayAdapter.createFromResource(getActivity(), R.array.PortSaid, android.R.layout.simple_spinner_item);
            arrayAdapter3.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            spinner_district_mohafzat.setAdapter(arrayAdapter3);
            spinner_district_mohafzat.setVisibility(View.VISIBLE);
            spinner_district_mohafzat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position >= 0 && count_of_conferme.get(position) >= 71) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.GONE);
                        lottieAnimationView3.setVisibility(View.GONE);
                        lottieAnimationView1.setVisibility(View.VISIBLE);
                        textView_out_stay_carefull.setText(getString(R.string.please_stay_home));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    } else if (position >= 0 && count_of_conferme.get(position) <= 70 && count_of_conferme.get(position) >= 30) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.VISIBLE);
                        lottieAnimationView3.setVisibility(View.GONE);
                        lottieAnimationView1.setVisibility(View.GONE);
                        textView_out_stay_carefull.setText(getString(R.string.please_be_carfull));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    } else if (position >= 0 && count_of_conferme.get(position) <= 29 && count_of_conferme.get(position) >= 1) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.GONE);
                        lottieAnimationView3.setVisibility(View.VISIBLE);
                        lottieAnimationView1.setVisibility(View.GONE);
                        textView_out_stay_carefull.setText(getString(R.string.please_go_out));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
        } else if (parent.getSelectedItemPosition() >= 0 && parent.getItemAtPosition(position).equals("Qalyubia") || parent.getItemAtPosition(position).equals("القليوبية") && parent.getSelectedItemPosition() >= 0) {
//            relativeLayout_st.setVisibility(View.GONE);
//            textView.setVisibility(View.GONE);
//            cardView.setVisibility(View.GONE);
            linearLayout_for_half_down_body.setVisibility(View.GONE);
            // Toast.makeText(getActivity(), "be carefully", Toast.LENGTH_SHORT).show();
            // Toast.makeText(getActivity(), count_of_conferme.get(position) + "", Toast.LENGTH_SHORT).show();
            final ArrayAdapter<CharSequence> arrayAdapter3 = ArrayAdapter.createFromResource(getActivity(), R.array.Qalyubia, android.R.layout.simple_spinner_item);
            arrayAdapter3.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            spinner_district_mohafzat.setAdapter(arrayAdapter3);
            spinner_district_mohafzat.setVisibility(View.VISIBLE);
            spinner_district_mohafzat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position >= 0 && count_of_conferme.get(position) >= 71) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.GONE);
                        lottieAnimationView3.setVisibility(View.GONE);
                        lottieAnimationView1.setVisibility(View.VISIBLE);
                        textView_out_stay_carefull.setText(getString(R.string.please_stay_home));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    } else if (position >= 0 && count_of_conferme.get(position) <= 70 && count_of_conferme.get(position) >= 30) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.VISIBLE);
                        lottieAnimationView3.setVisibility(View.GONE);
                        lottieAnimationView1.setVisibility(View.GONE);
                        textView_out_stay_carefull.setText(getString(R.string.please_be_carfull));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    } else if (position >= 0 && count_of_conferme.get(position) <= 29 && count_of_conferme.get(position) >= 1) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.GONE);
                        lottieAnimationView3.setVisibility(View.VISIBLE);
                        lottieAnimationView1.setVisibility(View.GONE);
                        textView_out_stay_carefull.setText(getString(R.string.please_go_out));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
        } else if (parent.getSelectedItemPosition() >= 0 && parent.getItemAtPosition(position).equals("Qena") || parent.getItemAtPosition(position).equals("قنا") && parent.getSelectedItemPosition() >= 0) {
//            relativeLayout_st.setVisibility(View.GONE);
//            textView.setVisibility(View.GONE);
//            cardView.setVisibility(View.GONE);
            linearLayout_for_half_down_body.setVisibility(View.GONE);
            // Toast.makeText(getActivity(), "be carefully", Toast.LENGTH_SHORT).show();
            // Toast.makeText(getActivity(), count_of_conferme.get(position) + "", Toast.LENGTH_SHORT).show();
            final ArrayAdapter<CharSequence> arrayAdapter3 = ArrayAdapter.createFromResource(getActivity(), R.array.Qena, android.R.layout.simple_spinner_item);
            arrayAdapter3.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            spinner_district_mohafzat.setAdapter(arrayAdapter3);
            spinner_district_mohafzat.setVisibility(View.VISIBLE);
            spinner_district_mohafzat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position >= 0 && count_of_conferme.get(position) >= 71) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.GONE);
                        lottieAnimationView3.setVisibility(View.GONE);
                        lottieAnimationView1.setVisibility(View.VISIBLE);
                        textView_out_stay_carefull.setText(getString(R.string.please_stay_home));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    } else if (position >= 0 && count_of_conferme.get(position) <= 70 && count_of_conferme.get(position) >= 30) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.VISIBLE);
                        lottieAnimationView3.setVisibility(View.GONE);
                        lottieAnimationView1.setVisibility(View.GONE);
                        textView_out_stay_carefull.setText(getString(R.string.please_be_carfull));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    } else if (position >= 0 && count_of_conferme.get(position) <= 29 && count_of_conferme.get(position) >= 1) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.GONE);
                        lottieAnimationView3.setVisibility(View.VISIBLE);
                        lottieAnimationView1.setVisibility(View.GONE);
                        textView_out_stay_carefull.setText(getString(R.string.please_go_out));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
        } else if (parent.getSelectedItemPosition() >= 0 && parent.getItemAtPosition(position).equals("Red Sea") || parent.getItemAtPosition(position).equals("البحر الاحمر") && parent.getSelectedItemPosition() >= 0) {
//            relativeLayout_st.setVisibility(View.GONE);
//            textView.setVisibility(View.GONE);
//            cardView.setVisibility(View.GONE);
            linearLayout_for_half_down_body.setVisibility(View.GONE);
            // Toast.makeText(getActivity(), "be carefully", Toast.LENGTH_SHORT).show();
            // Toast.makeText(getActivity(), count_of_conferme.get(position) + "", Toast.LENGTH_SHORT).show();
            final ArrayAdapter<CharSequence> arrayAdapter3 = ArrayAdapter.createFromResource(getActivity(), R.array.RedSea, android.R.layout.simple_spinner_item);
            arrayAdapter3.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            spinner_district_mohafzat.setAdapter(arrayAdapter3);
            spinner_district_mohafzat.setVisibility(View.VISIBLE);
            spinner_district_mohafzat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position >= 0 && count_of_conferme.get(position) >= 71) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.GONE);
                        lottieAnimationView3.setVisibility(View.GONE);
                        lottieAnimationView1.setVisibility(View.VISIBLE);
                        textView_out_stay_carefull.setText(getString(R.string.please_stay_home));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    } else if (position >= 0 && count_of_conferme.get(position) <= 70 && count_of_conferme.get(position) >= 30) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.VISIBLE);
                        lottieAnimationView3.setVisibility(View.GONE);
                        lottieAnimationView1.setVisibility(View.GONE);
                        textView_out_stay_carefull.setText(getString(R.string.please_be_carfull));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    } else if (position >= 0 && count_of_conferme.get(position) <= 29 && count_of_conferme.get(position) >= 1) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.GONE);
                        lottieAnimationView3.setVisibility(View.VISIBLE);
                        lottieAnimationView1.setVisibility(View.GONE);
                        textView_out_stay_carefull.setText(getString(R.string.please_go_out));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
        } else if (parent.getSelectedItemPosition() >= 0 && parent.getItemAtPosition(position).equals("Sharqia") || parent.getItemAtPosition(position).equals("الشرقية") && parent.getSelectedItemPosition() >= 0) {
//            relativeLayout_st.setVisibility(View.GONE);
//            textView.setVisibility(View.GONE);
//            cardView.setVisibility(View.GONE);
            linearLayout_for_half_down_body.setVisibility(View.GONE);
            // Toast.makeText(getActivity(), "be carefully", Toast.LENGTH_SHORT).show();
            // Toast.makeText(getActivity(), count_of_conferme.get(position) + "", Toast.LENGTH_SHORT).show();
            final ArrayAdapter<CharSequence> arrayAdapter3 = ArrayAdapter.createFromResource(getActivity(), R.array.Sharqia, android.R.layout.simple_spinner_item);
            arrayAdapter3.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            spinner_district_mohafzat.setAdapter(arrayAdapter3);
            spinner_district_mohafzat.setVisibility(View.VISIBLE);
            spinner_district_mohafzat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position >= 0 && count_of_conferme.get(position) >= 71) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.GONE);
                        lottieAnimationView3.setVisibility(View.GONE);
                        lottieAnimationView1.setVisibility(View.VISIBLE);
                        textView_out_stay_carefull.setText(getString(R.string.please_stay_home));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    } else if (position >= 0 && count_of_conferme.get(position) <= 70 && count_of_conferme.get(position) >= 30) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.VISIBLE);
                        lottieAnimationView3.setVisibility(View.GONE);
                        lottieAnimationView1.setVisibility(View.GONE);
                        textView_out_stay_carefull.setText(getString(R.string.please_be_carfull));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    } else if (position >= 0 && count_of_conferme.get(position) <= 29 && count_of_conferme.get(position) >= 1) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.GONE);
                        lottieAnimationView3.setVisibility(View.VISIBLE);
                        lottieAnimationView1.setVisibility(View.GONE);
                        textView_out_stay_carefull.setText(getString(R.string.please_go_out));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
        } else if (parent.getSelectedItemPosition() >= 0 && parent.getItemAtPosition(position).equals("Sohag") || parent.getItemAtPosition(position).equals("سوهاج") && parent.getSelectedItemPosition() >= 0) {
//            relativeLayout_st.setVisibility(View.GONE);
//            textView.setVisibility(View.GONE);
//            cardView.setVisibility(View.GONE);
            linearLayout_for_half_down_body.setVisibility(View.GONE);
            // Toast.makeText(getActivity(), "be carefully", Toast.LENGTH_SHORT).show();
            // Toast.makeText(getActivity(), count_of_conferme.get(position) + "", Toast.LENGTH_SHORT).show();
            final ArrayAdapter<CharSequence> arrayAdapter3 = ArrayAdapter.createFromResource(getActivity(), R.array.Sohag, android.R.layout.simple_spinner_item);
            arrayAdapter3.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            spinner_district_mohafzat.setAdapter(arrayAdapter3);
            spinner_district_mohafzat.setVisibility(View.VISIBLE);
            spinner_district_mohafzat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position >= 0 && count_of_conferme.get(position) >= 71) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.GONE);
                        lottieAnimationView3.setVisibility(View.GONE);
                        lottieAnimationView1.setVisibility(View.VISIBLE);
                        textView_out_stay_carefull.setText(getString(R.string.please_stay_home));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    } else if (position >= 0 && count_of_conferme.get(position) <= 70 && count_of_conferme.get(position) >= 30) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.VISIBLE);
                        lottieAnimationView3.setVisibility(View.GONE);
                        lottieAnimationView1.setVisibility(View.GONE);
                        textView_out_stay_carefull.setText(getString(R.string.please_be_carfull));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    } else if (position >= 0 && count_of_conferme.get(position) <= 29 && count_of_conferme.get(position) >= 1) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.GONE);
                        lottieAnimationView3.setVisibility(View.VISIBLE);
                        lottieAnimationView1.setVisibility(View.GONE);
                        textView_out_stay_carefull.setText(getString(R.string.please_go_out));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
        } else if (parent.getSelectedItemPosition() >= 0 && parent.getItemAtPosition(position).equals("South Sinai") || parent.getItemAtPosition(position).equals("جنوب سينا") && parent.getSelectedItemPosition() >= 0) {
//            relativeLayout_st.setVisibility(View.GONE);
//            textView.setVisibility(View.GONE);
//            cardView.setVisibility(View.GONE);
            linearLayout_for_half_down_body.setVisibility(View.GONE);
            // Toast.makeText(getActivity(), "be carefully", Toast.LENGTH_SHORT).show();
            // Toast.makeText(getActivity(), count_of_conferme.get(position) + "", Toast.LENGTH_SHORT).show();
            final ArrayAdapter<CharSequence> arrayAdapter3 = ArrayAdapter.createFromResource(getActivity(), R.array.SouthSinai, android.R.layout.simple_spinner_item);
            arrayAdapter3.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            spinner_district_mohafzat.setAdapter(arrayAdapter3);
            spinner_district_mohafzat.setVisibility(View.VISIBLE);
            spinner_district_mohafzat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position >= 0 && count_of_conferme.get(position) >= 71) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.GONE);
                        lottieAnimationView3.setVisibility(View.GONE);
                        lottieAnimationView1.setVisibility(View.VISIBLE);
                        textView_out_stay_carefull.setText(getString(R.string.please_stay_home));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    } else if (position >= 0 && count_of_conferme.get(position) <= 70 && count_of_conferme.get(position) >= 30) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.VISIBLE);
                        lottieAnimationView3.setVisibility(View.GONE);
                        lottieAnimationView1.setVisibility(View.GONE);
                        textView_out_stay_carefull.setText(getString(R.string.please_be_carfull));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    } else if (position >= 0 && count_of_conferme.get(position) <= 29 && count_of_conferme.get(position) >= 1) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.GONE);
                        lottieAnimationView3.setVisibility(View.VISIBLE);
                        lottieAnimationView1.setVisibility(View.GONE);
                        textView_out_stay_carefull.setText(getString(R.string.please_go_out));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
        } else if (parent.getSelectedItemPosition() >= 0 && parent.getItemAtPosition(position).equals("Suez") || parent.getItemAtPosition(position).equals("السويس") && parent.getSelectedItemPosition() >= 0) {
//            relativeLayout_st.setVisibility(View.GONE);
//            textView.setVisibility(View.GONE);
//            cardView.setVisibility(View.GONE);
            linearLayout_for_half_down_body.setVisibility(View.GONE);
            // Toast.makeText(getActivity(), "be carefully", Toast.LENGTH_SHORT).show();
            // Toast.makeText(getActivity(), count_of_conferme.get(position) + "", Toast.LENGTH_SHORT).show();
            final ArrayAdapter<CharSequence> arrayAdapter3 = ArrayAdapter.createFromResource(getActivity(), R.array.Suez, android.R.layout.simple_spinner_item);
            arrayAdapter3.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            spinner_district_mohafzat.setAdapter(arrayAdapter3);
            spinner_district_mohafzat.setVisibility(View.VISIBLE);
            spinner_district_mohafzat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position >= 0 && count_of_conferme.get(position) >= 71) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.GONE);
                        lottieAnimationView3.setVisibility(View.GONE);
                        lottieAnimationView1.setVisibility(View.VISIBLE);
                        textView_out_stay_carefull.setText(getString(R.string.please_stay_home));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    } else if (position >= 0 && count_of_conferme.get(position) <= 70 && count_of_conferme.get(position) >= 30) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.VISIBLE);
                        lottieAnimationView3.setVisibility(View.GONE);
                        lottieAnimationView1.setVisibility(View.GONE);
                        textView_out_stay_carefull.setText(getString(R.string.please_be_carfull));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    } else if (position >= 0 && count_of_conferme.get(position) <= 29 && count_of_conferme.get(position) >= 1) {
                        textView_tv_of_city.setText(count_of_conferme.get(position) + "");
                        //  Toast.makeText(getActivity(), count_of_conferme.get(position)+"", Toast.LENGTH_SHORT).show();
                        linearLayout_city_out_stay_becarfule_condations.setVisibility(View.VISIBLE);
                        lottieAnimationView_2.setVisibility(View.GONE);
                        lottieAnimationView3.setVisibility(View.VISIBLE);
                        lottieAnimationView1.setVisibility(View.GONE);
                        textView_out_stay_carefull.setText(getString(R.string.please_go_out));
                        textView_out_stay_carefull.setVisibility(View.VISIBLE);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) { }}); }
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        relativeLayout_st.setVisibility(View.VISIBLE);
        textView.setVisibility(View.VISIBLE);
        cardView.setVisibility(View.VISIBLE);
        linearLayout.setVisibility(View.GONE);
    }


}
