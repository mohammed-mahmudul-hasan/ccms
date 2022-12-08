package com.example.ccms.AdminBookingRequest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ccms.AdminHomePageActivity;
import com.example.ccms.LoadingDialog;
import com.example.ccms.R;
import com.example.ccms.UserBooking.BookingInfo;
import com.example.ccms.login;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AdminConfirmedActivity extends AppCompatActivity implements AdminConfirmedAdapter.OnItemClickListener {
    private TextView textView;
    private ActionBar actionBar;
    private AdminConfirmedAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private FirebaseAuth mAuth=FirebaseAuth.getInstance();
    private FirebaseFirestore db= FirebaseFirestore.getInstance();
    private CollectionReference ref_evening=db.collection("evening");
    private CollectionReference ref_day= db.collection("day");
    String current_date;
    private List<BookingInfo> mUploads;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_confirmed);


        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        textView=(TextView)findViewById(R.id.text_view);

        actionBar=getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0000FF")));
        actionBar.setTitle("Confirmed Booking Status");
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if (mAuth.getCurrentUser()==null){
            Toast.makeText(AdminConfirmedActivity.this,"You need to log in",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(AdminConfirmedActivity.this, AdminHomePageActivity.class));
            finish();
        }
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        current_date = simpleDateFormat.format(calendar.getTime());


        mRecyclerView = findViewById(R.id.recycler_view_confirmed);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mUploads = new ArrayList<>();
        mAdapter = new AdminConfirmedAdapter(AdminConfirmedActivity.this, mUploads);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(AdminConfirmedActivity.this);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.nav_upcoming:
                    AlertDialog.Builder alert=new AlertDialog.Builder(AdminConfirmedActivity.this);
                    View mView =getLayoutInflater().inflate(R.layout.select_shift_dialog,null);
                    Button evening=(Button)mView.findViewById(R.id.eve);
                    Button day=(Button)mView.findViewById(R.id.day);

                    alert.setView(mView);
                    final AlertDialog alertDialog=alert.create();
                    alertDialog.setCanceledOnTouchOutside(false);

                    evening.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            alertDialog.dismiss();
                            //progressBar.setVisibility(View.VISIBLE);
                            upcoming_method_evening_confirmed();
                        }
                    });
                    day.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            alertDialog.dismiss();
                            //progressBar.setVisibility(View.VISIBLE);
                            upcoming_method_day_confirmed();
                        }
                    });
                    alertDialog.show();
                    break;

                case R.id.nav_current:
                    AlertDialog.Builder alert2=new AlertDialog.Builder(AdminConfirmedActivity.this);
                    View mView2 =getLayoutInflater().inflate(R.layout.select_shift_dialog,null);
                    Button evening2=(Button)mView2.findViewById(R.id.eve);
                    Button day2=(Button)mView2.findViewById(R.id.day);

                    alert2.setView(mView2);
                    final AlertDialog alertDialog2=alert2.create();
                    alertDialog2.setCanceledOnTouchOutside(false);

                    evening2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            alertDialog2.dismiss();
                            current_method_evening_confirmed();
                        }
                    });
                    day2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            alertDialog2.dismiss();
                            current_method_day_confirmed();
                        }
                    });
                    alertDialog2.show();
                    break;
                case R.id.nav_previous:
                    AlertDialog.Builder alert3=new AlertDialog.Builder(AdminConfirmedActivity.this);
                    View mView3 =getLayoutInflater().inflate(R.layout.select_shift_dialog,null);
                    Button evening3=(Button)mView3.findViewById(R.id.eve);
                    Button day3=(Button)mView3.findViewById(R.id.day);

                    alert3.setView(mView3);
                    final AlertDialog alertDialog3=alert3.create();
                    alertDialog3.setCanceledOnTouchOutside(false);

                    evening3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            alertDialog3.dismiss();
                            previous_method_evening_confirmed();
                        }
                    });
                    day3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            alertDialog3.dismiss();
                            previous_method_day_confirmed();
                        }
                    });
                    alertDialog3.show();
                    break;

            }
            return true;
        }
    };
public void upcoming_method_evening_confirmed(){
  final LoadingDialog loadingDialog=new LoadingDialog(AdminConfirmedActivity.this);
   loadingDialog.startLoadingDialog();
   String checker="Confirmed";
   ref_evening.whereEqualTo("booking_status",checker)
        .orderBy("format_booked_date", Query.Direction.ASCENDING)
        .get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
        @Override
        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
            if (queryDocumentSnapshots.isEmpty()) {
                loadingDialog.dismissDialog();
                textView.setText("No confirmed booking history found for Evening shift");
            } else {
                mUploads.clear();
                for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                    String b_date=documentSnapshot.getId();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                    Date date=null;
                    try {
                        date=sdf.parse(b_date);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    Date date2 = null;
                    try {
                        date2 = sdf.parse(current_date);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    assert date != null;
                    if (date.after(date2)){
                        BookingInfo upload = documentSnapshot.toObject(BookingInfo.class);
                        mUploads.add(upload);
                    }
                }
                mAdapter.notifyDataSetChanged();
                loadingDialog.dismissDialog();
                if (mUploads==null || mUploads.isEmpty()){
                    textView.setText("No upcoming booking history found for Evening shift");
                }
                else {
                    textView.setText(""); }
            }
        }
    }).addOnFailureListener(new OnFailureListener() {
        @Override
        public void onFailure(@NonNull Exception e) {
            loadingDialog.dismissDialog();
            Toast.makeText(AdminConfirmedActivity.this,""+e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    });
    }

    public void upcoming_method_day_confirmed(){
        final LoadingDialog loadingDialog=new LoadingDialog(AdminConfirmedActivity.this);
        loadingDialog.startLoadingDialog();
        String checker="Confirmed";
        ref_day.whereEqualTo("booking_status",checker)
                .orderBy("format_booked_date", Query.Direction.ASCENDING)
                .get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                if (queryDocumentSnapshots.isEmpty()) {
                    loadingDialog.dismissDialog();
                    textView.setText("No upcoming confirmed booking status found for Day shift");
                } else {
                    mUploads.clear();
                    for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                        String b_date=documentSnapshot.getId();
                        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                        Date date=null;
                        try {
                            date=sdf.parse(b_date);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        Date date2 = null;
                        try {
                            date2 = sdf.parse(current_date);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        assert date != null;
                        if (date.after(date2)){
                            BookingInfo upload = documentSnapshot.toObject(BookingInfo.class);
                            mUploads.add(upload);
                        }
                    }
                    mAdapter.notifyDataSetChanged();
                    loadingDialog.dismissDialog();
                    if (mUploads==null || mUploads.isEmpty()){
                        textView.setText("No upcoming confirmed booking status found for Day shift");
                    }
                    else {
                        textView.setText(""); }
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                loadingDialog.dismissDialog();
                Toast.makeText(AdminConfirmedActivity.this,""+e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void current_method_evening_confirmed(){
        final LoadingDialog loadingDialog=new LoadingDialog(AdminConfirmedActivity.this);
        loadingDialog.startLoadingDialog();
        String checker="Confirmed";
        ref_evening.whereEqualTo("booking_status",checker)
                .get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                if (queryDocumentSnapshots.isEmpty()) {
                    loadingDialog.dismissDialog();
                    textView.setText("No current booking found for Evening shift");
                } else {
                    mUploads.clear();
                    for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                        String b_date=documentSnapshot.getId();
                        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                        Date date=null;
                        try {
                            date=sdf.parse(b_date);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        Date date2 = null;
                        try {
                            date2 = sdf.parse(current_date);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        assert date != null;
                        if (date.equals(date2)){
                            BookingInfo upload = documentSnapshot.toObject(BookingInfo.class);
                            mUploads.add(upload);
                        }
                    }
                    mAdapter.notifyDataSetChanged();
                    loadingDialog.dismissDialog();
                    if (mUploads==null || mUploads.isEmpty()){
                        textView.setText("No current booking found for Evening shift");
                    }
                    else {
                        textView.setText(""); }
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                loadingDialog.dismissDialog();
                Toast.makeText(AdminConfirmedActivity.this,""+e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void current_method_day_confirmed(){
        final LoadingDialog loadingDialog=new LoadingDialog(AdminConfirmedActivity.this);
        loadingDialog.startLoadingDialog();
        String checker="Confirmed";
        ref_day.whereEqualTo("booking_status",checker)
                .get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                if (queryDocumentSnapshots.isEmpty()) {
                    loadingDialog.dismissDialog();
                    textView.setText("No currrent booking found for Day shift");
                } else {
                    mUploads.clear();
                    for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                        String b_date=documentSnapshot.getId();
                        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                        Date date=null;
                        try {
                            date=sdf.parse(b_date);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        Date date2 = null;
                        try {
                            date2 = sdf.parse(current_date);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        assert date != null;
                        if (date.equals(date2)){
                            BookingInfo upload = documentSnapshot.toObject(BookingInfo.class);
                            mUploads.add(upload);
                        }
                    }
                    mAdapter.notifyDataSetChanged();
                    loadingDialog.dismissDialog();
                    if (mUploads==null || mUploads.isEmpty()){
                        textView.setText("No current booking found for Day shift");
                    }
                    else {
                        textView.setText(""); }
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                loadingDialog.dismissDialog();
                Toast.makeText(AdminConfirmedActivity.this,""+e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void previous_method_evening_confirmed(){
        final LoadingDialog loadingDialog=new LoadingDialog(AdminConfirmedActivity.this);
        loadingDialog.startLoadingDialog();
        String checker="Confirmed";
        ref_evening.whereEqualTo("booking_status",checker)
                .orderBy("format_booked_date", Query.Direction.DESCENDING)
                .get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                if (queryDocumentSnapshots.isEmpty()) {
                    loadingDialog.dismissDialog();
                    textView.setText("No previous booking history found for Evening shift");
                } else {
                    mUploads.clear();
                    for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                        String b_date=documentSnapshot.getId();
                        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                        Date date=null;
                        try {
                            date=sdf.parse(b_date);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        Date date2 = null;
                        try {
                            date2 = sdf.parse(current_date);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        assert date != null;
                        if (date.before(date2)){
                            BookingInfo upload = documentSnapshot.toObject(BookingInfo.class);
                            mUploads.add(upload);
                        }
                    }
                    mAdapter.notifyDataSetChanged();
                    loadingDialog.dismissDialog();
                    if (mUploads==null || mUploads.isEmpty()){
                        textView.setText("No previous booking history found for Evening shift");
                    }
                    else {
                        textView.setText(""); }
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                loadingDialog.dismissDialog();
                Toast.makeText(AdminConfirmedActivity.this,""+e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void previous_method_day_confirmed(){
        final LoadingDialog loadingDialog=new LoadingDialog(AdminConfirmedActivity.this);
        loadingDialog.startLoadingDialog();
        String checker="Confirmed";
        ref_day.whereEqualTo("booking_status",checker)
                .orderBy("format_booked_date", Query.Direction.DESCENDING)
                .get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                if (queryDocumentSnapshots.isEmpty()) {
                    loadingDialog.dismissDialog();
                    textView.setText("No previous booking history found for Day shift");
                } else {
                    mUploads.clear();
                    for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                        String b_date=documentSnapshot.getId();
                        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                        Date date=null;
                        try {
                            date=sdf.parse(b_date);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        Date date2 = null;
                        try {
                            date2 = sdf.parse(current_date);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        assert date != null;
                        if (date.before(date2)){
                            BookingInfo upload = documentSnapshot.toObject(BookingInfo.class);
                            mUploads.add(upload);
                        }
                    }
                    mAdapter.notifyDataSetChanged();
                    loadingDialog.dismissDialog();
                    if (mUploads==null || mUploads.isEmpty()){
                        textView.setText("No previous booking history found for Day shift");
                    }
                    else {
                        textView.setText(""); }
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                loadingDialog.dismissDialog();
                Toast.makeText(AdminConfirmedActivity.this,""+e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public void onItemClick(int position) {
        BookingInfo selectedItem = mUploads.get(position);
        // Toast.makeText(this, "Normal click at position: " + position, Toast.LENGTH_SHORT).show();
        AlertDialog.Builder alert=new AlertDialog.Builder(AdminConfirmedActivity.this);
        View mView =getLayoutInflater().inflate(R.layout.booking_info_dialogue,null);

        ImageView cancel=(ImageView)mView.findViewById(R.id.icon_cancel);
        Button close_btn=(Button)mView.findViewById(R.id.close_button);

        TextView booking_Id=(TextView)mView.findViewById(R.id.booking_id);
        booking_Id.setText(selectedItem.getBooking_Id());
        TextView shift=(TextView)mView.findViewById(R.id.shift);
        shift.setText(selectedItem.getShift());
        TextView booked_date=(TextView)mView.findViewById(R.id.bookedDate);
        booked_date.setText(selectedItem.getBooked_date());
        TextView request_date=(TextView)mView.findViewById(R.id.requestDate);
        String d=selectedItem.getDate_of_booking_request()+" "+selectedItem.getBooking_time();
        request_date.setText(d);
        TextView event_type=(TextView)mView.findViewById(R.id.eventType);
        event_type.setText(selectedItem.getEvent_type());
        TextView guests=(TextView)mView.findViewById(R.id.guests);
        guests.setText(selectedItem.getNumber_of_guests());
        TextView cost=(TextView)mView.findViewById(R.id.cost);
        cost.setText(selectedItem.getHall_rental_price());
        TextView payment=(TextView)mView.findViewById(R.id.paymentStatus);
        payment.setText(selectedItem.getPayment_status());
        TextView booking_status=(TextView)mView.findViewById(R.id.bookingStatus);
        booking_status.setText(selectedItem.getBooking_status());
        TextView email=(TextView)mView.findViewById(R.id.Email);
        email.setText(selectedItem.getEmail());
        TextView name=(TextView)mView.findViewById(R.id.Name);
        name.setText(selectedItem.getName());
        TextView mobile=(TextView)mView.findViewById(R.id.Mobile);
        mobile.setText(selectedItem.getMobile());
        TextView add_mobile=(TextView)mView.findViewById(R.id.AddMobile);
        add_mobile.setText(selectedItem.getAdditional_mobile());
        TextView address=(TextView)mView.findViewById(R.id.Address);
        address.setText(selectedItem.getAddress());


        alert.setView(mView);
        final AlertDialog alertDialog=alert.create();
        alertDialog.setCanceledOnTouchOutside(false);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        close_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

        alertDialog.show();
    }

    @Override
    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
    }
}
