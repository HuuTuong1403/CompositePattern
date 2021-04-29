package com.example.compositepatternphone;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    private ExpandableListView expandableListView;
    private ExpandableListAdapter adapter;
    private Brands samsung, iphone;
    private ArrayList<Phone> phonesSamsung, phonesIphone, phoneIphoneS, phoneAll;
    private ProductLines samsungalaxy, iPhone, iPhoneS;
    private ArrayList<ProductLines> productLinesSamSung, productLinesIphone;
    private List<String> lstHeader = new ArrayList<>();
    private HashMap<String, List<String>> lstChild = new HashMap<>();
    private List<Brands> lstBrands;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        ProductLine();
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        expandableListView = (ExpandableListView)findViewById(R.id.navigationmenu);
        addDrawersItem();
        Bundle bundle = new Bundle();
        bundle.putSerializable("key", phoneAll);
        FragmentPhone fragmentPhone = new FragmentPhone();
        fragmentPhone.setArguments(bundle);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        ft.replace(R.id.nav_host_fragment, fragmentPhone);
        ft.commit();

    }


    private void addDrawersItem() {
        adapter = new ExpandedAdapter(this, lstHeader, lstChild);
        expandableListView.setAdapter(adapter);
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                String selectedItem = lstHeader.get(groupPosition).toString();
                getSupportActionBar().setTitle(selectedItem);
                Bundle bundle = new Bundle();
                if(selectedItem == "Samsung"){
                    bundle.putSerializable("key", samsung.getItems());
                }
                else{
                    bundle.putSerializable("key", iphone.getItems());
                }
                FragmentPhone fragmentPhone = new FragmentPhone();
                fragmentPhone.setArguments(bundle);
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

                ft.replace(R.id.nav_host_fragment, fragmentPhone);
                ft.commit();

                return false;
            }
        });
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                getSupportActionBar().setTitle(lstHeader.get(groupPosition));
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                getSupportActionBar().setTitle("Home");
                Bundle bundle = new Bundle();
                bundle.putSerializable("key", lstBrands.get(groupPosition).getItems());
                FragmentPhone fragmentPhone = new FragmentPhone();
                fragmentPhone.setArguments(bundle);
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

                ft.replace(R.id.nav_host_fragment, fragmentPhone);
                ft.commit();
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                String selectedItem = ((List) (lstChild.get(lstHeader.get(groupPosition)))).get(childPosition).toString();
                getSupportActionBar().setTitle(selectedItem);
                Bundle bundle = new Bundle();
                switch (selectedItem){
                    case "Samsung Galaxy":
                        bundle.putSerializable("key", samsungalaxy.getItems());
                        break;
                    case "iPhone":
                        bundle.putSerializable("key", iPhone.getItems());
                        break;
                    case "iPhoneS":
                        bundle.putSerializable("key", iPhoneS.getItems());
                        break;
                }
                FragmentPhone fragmentPhone = new FragmentPhone();
                fragmentPhone.setArguments(bundle);
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

                ft.replace(R.id.nav_host_fragment, fragmentPhone);
                ft.commit();
                return false;
            }
        });
    }

    public void PhoneSamSung(){
        Phone samsungGalaxyA51 = new Phone("Samsung Galaxy A51", "(6GB/128GB)", R.drawable.samsunggalaxya51, "5.890.000₫");
        Phone samsungGalaxyA50s = new Phone("Samsung Galaxy A10s", "(2GB/32GB)", R.drawable.samsunga10s, "2.350.000₫");
        Phone samsungGalaxyA02s = new Phone("Samsung Galaxy A02s", "(4GB/64GB)", R.drawable.samsungalaxya02s, "2.818.000₫");
        Phone samsungGalaxyM31 = new Phone("Samsung Galaxy M31", "(6GB/128GB)", R.drawable.samsunga10s, "4.890.000₫");
        Phone samsungGalaxyM11 = new Phone("Samsung Galaxy M11", "(3GB/32GB)", R.drawable.samsunggalaxym11, "2.790.000₫");

        phonesSamsung = new ArrayList<>();
        phonesSamsung.add(samsungGalaxyA51);
        phonesSamsung.add(samsungGalaxyA50s);
        phonesSamsung.add(samsungGalaxyA02s);
        phonesSamsung.add(samsungGalaxyM31);
        phonesSamsung.add(samsungGalaxyM11);

        Phone iPhone4 = new Phone("iPhone 4", "8GB", R.drawable.iphone4, "450.000₫");
        Phone iPhone5 = new Phone("iPhone 5", "16GB", R.drawable.iphone5, "490.000₫");
        Phone iPhone6 = new Phone("iPhone 6", "32GB", R.drawable.iphone6, "1.799.000₫");
        Phone iPhone7 = new Phone("iPhone 7", "32GB", R.drawable.iphone7, "3.399.000₫");
        Phone iPhone8 = new Phone("iPhone 8", "64GB", R.drawable.iphone8, "4.490.000₫");

        phonesIphone = new ArrayList<>();
        phonesIphone.add(iPhone4);
        phonesIphone.add(iPhone5);
        phonesIphone.add(iPhone6);
        phonesIphone.add(iPhone7);
        phonesIphone.add(iPhone8);

        Phone iPhone4s = new Phone("iPhone 4s", "8GB", R.drawable.iphone4s, "490.000₫");
        Phone iPhone5s = new Phone("iPhone 5s", "16GB", R.drawable.iphone5s, "579.000₫");
        Phone iPhone6s = new Phone("iPhone 6s", "32GB", R.drawable.iphone6s, "2.100.000₫");

        phoneIphoneS = new ArrayList<>();
        phoneIphoneS.add(iPhone4s);
        phoneIphoneS.add(iPhone5s);
        phoneIphoneS.add(iPhone6s);

        phoneAll = new ArrayList<>();
        for(Phone phone: phonesSamsung){
            phoneAll.add(phone);
        }
        for(Phone phone: phoneIphoneS){
            phoneAll.add(phone);
        }
        for(Phone phone: phonesIphone){
            phoneAll.add(phone);
        }
    }
    public void ProductLine(){
        PhoneSamSung();
        samsungalaxy = new ProductLines("Samsung Galaxy", phonesSamsung);
        productLinesSamSung = new ArrayList<>();
        productLinesSamSung.add(samsungalaxy);

        iPhone = new ProductLines("iPhone", phonesIphone);
        productLinesIphone = new ArrayList<>();
        productLinesIphone.add(iPhone);

        iPhoneS = new ProductLines("iPhoneS", phoneIphoneS);
        productLinesIphone.add(iPhoneS);

        samsung = new Brands("Samsung", productLinesSamSung);
        iphone = new Brands("iPhone", productLinesIphone);
        lstBrands = new ArrayList<>();
        lstBrands.add(samsung);
        lstBrands.add(iphone);

        lstHeader.add(samsung.getBrandName());
        lstHeader.add(iphone.getBrandName());

        List<String> productSamsung = new ArrayList<>();
        productSamsung.add(samsungalaxy.getLineName());

        List<String> productiPhone = new ArrayList<>();
        productiPhone.add(iPhone.getLineName());
        productiPhone.add(iPhoneS.getLineName());

        lstChild.put(samsung.getBrandName(), productSamsung);
        lstChild.put(iphone.getBrandName(), productiPhone);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }



}