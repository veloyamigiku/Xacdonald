package jp.co.myself.xacdonald.fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.location.Location;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import org.jetbrains.annotations.NotNull;

import io.reactivex.android.schedulers.AndroidSchedulers;
import jp.co.myself.xacdonald.R;
import jp.co.myself.xacdonald.activity.MainActivity;
import jp.co.myself.xacdonald.model.view.menu.MenuItem;
import jp.co.myself.xacdonald.model.view.shop.Shop;
import jp.co.myself.xacdonald.utils.DpPx;
import jp.co.myself.xacdonald.utils.StringUtils;
import jp.co.myself.xacdonald.view.common.BaseTitleHeader;
import jp.co.myself.xacdonald.view.common.TitleSubHeader;
import jp.co.myself.xacdonald.view.shop.OrderMenuView;
import jp.co.myself.xacdonald.view.shop.ShopItemDecoration;
import jp.co.myself.xacdonald.view.shop.ShopRecyclerViewAdapter;
import jp.co.myself.xacdonald.viewmodel.ShopViewModel;
import jp.co.myself.xacdonald.viewmodel.ShopViewModelFactory;

public class ShopFragment extends Fragment implements OnMapReadyCallback {

    private static final int REQUSET_PERMISSION_CODE = 1;

    private MenuItem menuItem;

    private FusedLocationProviderClient fusedLocationClient;

    private SupportMapFragment mapFragment;

    private GoogleMap gm;

    private ShopRecyclerViewAdapter srva;

    public ShopFragment() {
        // Required empty public constructor
    }

    public static ShopFragment newInstance() {
        ShopFragment fragment = new ShopFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            menuItem = ShopFragmentArgs.fromBundle(getArguments()).getMenuItem();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ConstraintLayout cl = new ConstraintLayout(getContext());

        TitleSubHeader th = new TitleSubHeader(getContext());
        th.setId(View.generateViewId());
        SpannableStringBuilder titleSsb = new SpannableStringBuilder();
        titleSsb.append("どちらの店舗で受け取りますか");
        titleSsb.setSpan(
                new AbsoluteSizeSpan(16, true),
                0,
                titleSsb.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        titleSsb.setSpan(
                new StyleSpan(Typeface.BOLD),
                0,
                titleSsb.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        th.titleTv.setText(titleSsb);
        th.subTitleTv.setText("店舗によりお取り扱いの無い商品がある場合があります。");
        th.setDelegate(new BaseTitleHeader.TitleHeaderDelegate() {
            @Override
            public void tapLeftBtn() {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.popBackStackForFragment();
            }
        });
        cl.addView(th);
        ConstraintSet thCs = new ConstraintSet();
        thCs.constrainWidth(
                th.getId(),
                ConstraintSet.MATCH_CONSTRAINT);
        thCs.constrainHeight(
                th.getId(),
                ConstraintSet.WRAP_CONTENT);
        thCs.connect(
                th.getId(),
                ConstraintSet.TOP,
                ConstraintSet.PARENT_ID,
                ConstraintSet.TOP,
                DpPx.convertDp2Px(0, getContext()));
        thCs.connect(
                th.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                DpPx.convertDp2Px(0, getContext()));
        thCs.connect(
                th.getId(),
                ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                DpPx.convertDp2Px(0, getContext()));
        thCs.applyTo(cl);

        OrderMenuView omv = new OrderMenuView(getContext());
        omv.setId(View.generateViewId());
        Glide
                .with(omv.imageView)
                .load(menuItem.getImgUrl())
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .into(omv.imageView);
        omv.nameTv.setText(menuItem.getName());
        omv.priceTv.setText(StringUtils.getPriceStringWithLabel(
                16,
                22,
                menuItem.getPrice(),
                "",
                16));
        cl.addView(omv);
        ConstraintSet omvCs = new ConstraintSet();
        omvCs.constrainWidth(
                omv.getId(),
                ConstraintSet.MATCH_CONSTRAINT);
        omvCs.constrainHeight(
                omv.getId(),
                ConstraintSet.WRAP_CONTENT);
        omvCs.connect(
                omv.getId(),
                ConstraintSet.TOP,
                th.getId(),
                ConstraintSet.BOTTOM,
                DpPx.convertDp2Px(5, getContext()));
        omvCs.connect(
                omv.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                DpPx.convertDp2Px(5, getContext()));
        omvCs.connect(
                omv.getId(),
                ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                DpPx.convertDp2Px(5, getContext()));
        omvCs.applyTo(cl);

        FrameLayout fl = new FrameLayout(getContext());
        fl.setId(View.generateViewId());
        fl.setBackgroundColor(Color.MAGENTA);
        cl.addView(fl);
        ConstraintSet flCs = new ConstraintSet();
        flCs.constrainWidth(
                fl.getId(),
                ConstraintSet.MATCH_CONSTRAINT);
        flCs.constrainPercentHeight(
                fl.getId(),
                0.3f);
        flCs.connect(
                fl.getId(),
                ConstraintSet.TOP,
                omv.getId(),
                ConstraintSet.BOTTOM,
                DpPx.convertDp2Px(5, getContext()));
        flCs.connect(
                fl.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                0);
        flCs.connect(
                fl.getId(),
                ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                0);
        flCs.applyTo(cl);

        mapFragment = SupportMapFragment.newInstance();
        FragmentManager fm = getChildFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(
                fl.getId(),
                mapFragment);
        ft.commit();
        mapFragment.getMapAsync(this);

        RecyclerView rv = new RecyclerView(getContext());
        rv.setId(View.generateViewId());
        rv.setBackgroundColor(getResources().getColor(R.color.shop_item_background));
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        srva = new ShopRecyclerViewAdapter() {
            @Override
            public void onItemClick() {
                ShopFragmentDirections.ActionShopFragmentToMenuOrderFragment directions = ShopFragmentDirections.actionShopFragmentToMenuOrderFragment(menuItem);
                Navigation.findNavController(cl).navigate(directions);
            }
        };
        rv.setAdapter(srva);
        rv.addItemDecoration(new ShopItemDecoration(
                DpPx.convertDp2Px(10, getContext()),
                DpPx.convertDp2Px(10, getContext()),
                DpPx.convertDp2Px(10, getContext()),
                DpPx.convertDp2Px(10, getContext())));
        cl.addView(rv);
        ConstraintSet rvCs = new ConstraintSet();
        rvCs.constrainWidth(
                rv.getId(),
                ConstraintSet.MATCH_CONSTRAINT);
        rvCs.constrainHeight(
                rv.getId(),
                ConstraintSet.MATCH_CONSTRAINT);
        rvCs.connect(
                rv.getId(),
                ConstraintSet.TOP,
                fl.getId(),
                ConstraintSet.BOTTOM,
                0);
        rvCs.connect(
                rv.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                0);
        rvCs.connect(
                rv.getId(),
                ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                0);
        rvCs.connect(
                rv.getId(),
                ConstraintSet.BOTTOM,
                ConstraintSet.PARENT_ID,
                ConstraintSet.BOTTOM,
                0);
        rvCs.applyTo(cl);

        return cl;
    }

    private void getLocation() {

        if (fusedLocationClient == null) {
            fusedLocationClient = LocationServices.getFusedLocationProviderClient(getContext());
        }

        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(
                    new String[]{
                            Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION
                    },
                    REQUSET_PERMISSION_CODE);
        } else {
            gm.setMyLocationEnabled(true);
            fusedLocationClient
                    .getLastLocation()
                    .addOnFailureListener(
                            getActivity(),
                            new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull @NotNull Exception e) {
                                    Log.d(ShopFragment.class.getSimpleName(), e.getMessage());
                                }
                            })
                    .addOnSuccessListener(
                            getActivity(),
                            new OnSuccessListener<Location>() {
                                @Override
                                public void onSuccess(Location location) {
                                    gm.animateCamera(CameraUpdateFactory.newLatLngZoom(
                                            new LatLng(
                                                    location.getLatitude(),
                                                    location.getLongitude()),
                                            16));
                                    ShopViewModel svm = new ViewModelProvider(getActivity(), new ShopViewModelFactory()).get(ShopViewModel.class);
                                    svm
                                            .getShop(
                                                    location.getLatitude(),
                                                    location.getLongitude())
                                            .observeOn(AndroidSchedulers.mainThread())
                                            .subscribe(
                                                    (shop) -> {
                                                        Log.d(ShopFragment.class.getSimpleName(), "Next");
                                                        for (Shop s : shop) {
                                                            gm.addMarker(new MarkerOptions()
                                                                    .title(s.getName())
                                                                    .snippet("店舗を選択してください")
                                                                    .position(new LatLng(s.getLat(), s.getLon())));
                                                            //gm.setInfoWindowAdapter();
                                                            gm.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                                                                @Override
                                                                public boolean onMarkerClick(@NonNull @NotNull Marker marker) {
                                                                    return false;
                                                                }
                                                            });
                                                            gm.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                                                                @Override
                                                                public void onInfoWindowClick(@NonNull @NotNull Marker marker) {

                                                                }
                                                            });
                                                        }
                                                        srva.setShopList(shop);
                                                        srva.notifyDataSetChanged();
                                                    },
                                                    (error) -> {
                                                        Log.d(ShopFragment.class.getSimpleName(), error.getMessage());
                                                    }
                                            );
                                }
                            });
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull @NotNull String[] permissions, @NonNull @NotNull int[] grantResults) {
        switch (requestCode) {
            case REQUSET_PERMISSION_CODE:
                getLocation();
                break;
        }
    }


    @Override
    public void onMapReady(@NonNull @NotNull GoogleMap googleMap) {
        gm = googleMap;
        getLocation();
    }
}
