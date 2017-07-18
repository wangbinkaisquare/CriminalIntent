package com.bignerdranch.android.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by amy on 5/13/2017.
 */

public class CrimeLabel {

    private static CrimeLabel instance;
    private List<Crime> mCrimes;

    public static CrimeLabel getInstance(Context context) {
        if (instance == null) {
            instance = new CrimeLabel(context);
        }

        return instance;
    }

    private CrimeLabel(Context context) {
        mCrimes = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Crime crime = new Crime();
            crime.setTitle("Crime #" + i);
            crime.setSolved(i % 2 == 0);
            mCrimes.add(crime);
        }
    }

    public List<Crime> getCrimes() {
        return mCrimes;
    }

    public Crime getCrime(UUID id) {
        for (Crime crime : mCrimes) {
            if (crime.getId().equals(id)) {
                return crime;
            }
        }
        return  null;
    }
}
