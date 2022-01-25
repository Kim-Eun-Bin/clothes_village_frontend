package com.example.clothesvillage.home;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.clothesvillage.L;
import com.example.clothesvillage.R;
import com.example.clothesvillage.base.BaseFragment;
import com.example.clothesvillage.databinding.FragmentHomeBinding;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class HomeFragment extends BaseFragment<FragmentHomeBinding> {

    private View view;

    private ArrayList<WData> mDataset = new ArrayList<WData>();
    private Context mContext;
    //private WData data;


    @Override
    protected int layoutRes() {
        return R.layout.fragment_home;
    }

    @Override
    protected void onViewCreated() {
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        //mContext = context;
        String URL = "https://search.naver.com/search.naver?where=nexearch&sm=top_sly.hst&fbm=0&acr=1&acq=%EC%98%A4%EB%8A%98%EB%82%A0&qdt=0&ie=utf8&query=오늘날씨";
        WeatherAsynTask task = new WeatherAsynTask();
        task.execute(URL);
    }

    private class WeatherAsynTask extends AsyncTask<String, Void, String> {

        WData data = new WData();
        String weather_state = "";
        ProgressDialog progressDialog = new ProgressDialog(getActivity());

        public WeatherAsynTask() {
            //
        }

        @Override
        protected void onPreExecute() {
            //super.onPreExecute();
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setMessage("날씨를 로딩중입니다");
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... params) {

            String URL = params[0];
            String E1 = "div[class=main_info]";
            String E0 = "div[class=sort_box _areaSelectLayer]";
            try {
                Document document = Jsoup.connect(URL).get();
                Elements address = document.select(E0);
                Elements elements = document.select(E1);

//                L.i("::::address " + address);
//                L.i("::::elements " + elements);
//                for(Element element : elements) {

//                E0 = "span[class=btn_select] em";
//                Elements e0 = address.select(E0);
//                L.i("::::e0 " + e0.select("em"));
//                for (Element element : e0) {
//                    L.e(":::::::::::element " + element);
//                }


                E1 = "p[class=cast_txt]";
                Elements e1 = document.select(E1);
                data.setContent(e1.get(0).text());

                E1 = "p[class=info_temperature]";
                Elements e2 = document.select(E1);
                data.setTemperature(e2.text().substring(0, 2));


                E1 = "span[class=merge]";
                Elements e3 = document.select(E1);
                data.setHigh_Low_temp(e3.text());

                E1 = "div[class=main_info] span";
                Elements e4 = document.select(E1);
                weather_state = e4.attr("class");
//                }

            } catch (Exception e) {
                e.printStackTrace();
                L.i("::::::e" + e.getMessage());
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {
                binding.textviewWeatherContent.setText(data.getContent());
                binding.textviewWeatherHighlowtemp.setText(data.getHigh_low_temp());
                binding.textviewWeatherTemperature.setText(data.getTemperature() + "℃");
                recommend_style(Integer.parseInt(data.getTemperature()));
                setWeather(weather_state);
                progressDialog.dismiss();
            } catch (Exception e) {
                L.e(":::::e " + e.getMessage());
                progressDialog.dismiss();
            }

        }

        public void setWeather(String w_state) {
            switch (w_state) {
                case "ico_state ws1": //맑음(낮)
                    binding.imageviewWeatherPicture.setImageResource(R.drawable.ws1);
                    break;
                case "ico_state ws2": //맑음(밤)
                    binding.imageviewWeatherPicture.setImageResource(R.drawable.ws2);
                    break;
                case "ico_state ws3": //구름조금(낮)
                    binding.imageviewWeatherPicture.setImageResource(R.drawable.ws3);
                    break;
                case "ico_state ws4": //구름조금(밤)
                    binding.imageviewWeatherPicture.setImageResource(R.drawable.ws4);
                    break;
                case "ico_state ws5": //구름많음(낮)
                    binding.imageviewWeatherPicture.setImageResource(R.drawable.ws5);
                    break;
                case "ico_state ws6": //구름많음(밤)
                    binding.imageviewWeatherPicture.setImageResource(R.drawable.ws6);
                    break;
                case "ico_state ws7": //흐림
                    binding.imageviewWeatherPicture.setImageResource(R.drawable.ws7);
                    break;
                case "ico_state ws8": //약한비
                    binding.imageviewWeatherPicture.setImageResource(R.drawable.ws8);
                    break;
                case "ico_state ws9": //비
                    binding.imageviewWeatherPicture.setImageResource(R.drawable.ws9);
                    break;
                case "ico_state ws10": //강한비
                    binding.imageviewWeatherPicture.setImageResource(R.drawable.ws10);
                    break;
                case "ico_state ws11": //약한눈
                    binding.imageviewWeatherPicture.setImageResource(R.drawable.ws11);
                    break;
                case "ico_state ws12": //눈
                    binding.imageviewWeatherPicture.setImageResource(R.drawable.ws12);
                    break;
                case "ico_state ws13": //강한눈
                    binding.imageviewWeatherPicture.setImageResource(R.drawable.ws13);
                    break;
                case "ico_state ws14": //진눈깨비
                    binding.imageviewWeatherPicture.setImageResource(R.drawable.ws14);
                    break;
                case "ico_state ws15": //소나기
                    binding.imageviewWeatherPicture.setImageResource(R.drawable.ws15);
                    break;
                case "ico_state ws16": //소낙눈
                    binding.imageviewWeatherPicture.setImageResource(R.drawable.ws16);
                    break;
                case "ico_state ws17": //안개
                    binding.imageviewWeatherPicture.setImageResource(R.drawable.ws17_40);
                    break;
                case "ico_state ws18": //번개, 뇌우
                    binding.imageviewWeatherPicture.setImageResource(R.drawable.ws18);
                    break;
                case "ico_state ws19": //우박
                    binding.imageviewWeatherPicture.setImageResource(R.drawable.ws19);
                    break;
                case "ico_state ws20": //황사
                    binding.imageviewWeatherPicture.setImageResource(R.drawable.ws20_41);
                    break;
                case "ico_state ws21": //비 또는 눈
                    binding.imageviewWeatherPicture.setImageResource(R.drawable.ws21);
                    break;
                case "ico_state ws22": //가끔비
                    binding.imageviewWeatherPicture.setImageResource(R.drawable.ws22_31);
                    break;
                case "ico_state ws23": //가끔눈
                    binding.imageviewWeatherPicture.setImageResource(R.drawable.ws23_32);
                    break;
                case "ico_state ws24": //가끔비 또는 눈
                    binding.imageviewWeatherPicture.setImageResource(R.drawable.ws24_33);
                    break;
                case "ico_state ws25": //흐린후갬
                    binding.imageviewWeatherPicture.setImageResource(R.drawable.ws25);
                    break;
                case "ico_state ws26": //뇌우후갬
                    binding.imageviewWeatherPicture.setImageResource(R.drawable.ws26);
                    break;
                case "ico_state ws27": //비후갬
                    binding.imageviewWeatherPicture.setImageResource(R.drawable.ws27);
                    break;
                case "ico_state ws28": //눈후갬
                    binding.imageviewWeatherPicture.setImageResource(R.drawable.ws28);
                    break;
                case "ico_state ws29": //흐려져비
                    binding.imageviewWeatherPicture.setImageResource(R.drawable.ws29);
                    break;
                case "ico_state ws30": //흐려져눈
                    binding.imageviewWeatherPicture.setImageResource(R.drawable.ws30);
                    break;
                case "ico_state ws31": //가끔비(밤)
                    binding.imageviewWeatherPicture.setImageResource(R.drawable.ws22_31);
                    break;
                case "ico_state ws32": //가끔눈(밤)
                    binding.imageviewWeatherPicture.setImageResource(R.drawable.ws23_32);
                    break;
                case "ico_state ws33": //가끔비 또는 눈(밤)
                    binding.imageviewWeatherPicture.setImageResource(R.drawable.ws24_33);
                    break;
                case "ico_state ws34": //흐린후갬(밤)
                    binding.imageviewWeatherPicture.setImageResource(R.drawable.ws34);
                    break;
                case "ico_state ws35": //뇌우후갬(밤)
                    binding.imageviewWeatherPicture.setImageResource(R.drawable.ws35);
                    break;
                case "ico_state ws36": //비후갬(밤)
                    binding.imageviewWeatherPicture.setImageResource(R.drawable.ws36);
                    break;
                case "ico_state ws37": //눈후갬(밤)
                    binding.imageviewWeatherPicture.setImageResource(R.drawable.ws37);
                    break;
                case "ico_state ws38": //흐려져비(밤)
                    binding.imageviewWeatherPicture.setImageResource(R.drawable.ws38);
                    break;
                case "ico_state ws39": //흐려져눈(밤)
                    binding.imageviewWeatherPicture.setImageResource(R.drawable.ws39);
                    break;
                case "ico_state ws40": //안개(밤)
                    binding.imageviewWeatherPicture.setImageResource(R.drawable.ws17_40);
                    break;
                case "ico_state ws41": //황사(밤)
                    binding.imageviewWeatherPicture.setImageResource(R.drawable.ws20_41);
                    break;
            }
        }

        public void recommend_style(int temperature) {
            if (temperature < -5) {
                binding.textviewRecomandStyle.setText("두꺼운 코트, 롱패딩, 모자, 귀마개");
            } else if (temperature < 9) {
                binding.textviewRecomandStyle.setText("가벼운 코트, 라이더 자켓");
            } else if (temperature < 11) {
                binding.textviewRecomandStyle.setText("트렌치 코트, 면자켓");
            } else if (temperature < 16) {
                binding.textviewRecomandStyle.setText("자켓, 셔츠, 가디건, 치마");
            } else if (temperature < 19) {
                binding.textviewRecomandStyle.setText("니트, 가디건, 후드티, 맨투맨, 청바지, 면바지");
            } else if (temperature < 22) {
                binding.textviewRecomandStyle.setText("긴팔, 가디건, 면바지, 슬랙스");
            } else if (temperature < 26) {
                binding.textviewRecomandStyle.setText("반팔, 얇은 셔츠, 반바지");
            } else {
                binding.textviewRecomandStyle.setText("민소매, 반바지, 원피스");
            }
        }
    }
}
