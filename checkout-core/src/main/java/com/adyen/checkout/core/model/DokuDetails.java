package com.adyen.checkout.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Copyright (c) 2017 Adyen B.V.
 * <p>
 * This file is open source and available under the MIT license. See the LICENSE file for more info.
 * <p>
 * Created by emmanuel on 04/12/2017.
 */
public final class DokuDetails extends PaymentMethodDetails {
    public static final Parcelable.Creator<DokuDetails> CREATOR = new Parcelable.Creator<DokuDetails>() {
        @Override
        public DokuDetails createFromParcel(Parcel parcel) {
            return new DokuDetails(parcel);
        }

        @Override
        public DokuDetails[] newArray(int size) {
            return new DokuDetails[size];
        }
    };

    public static final String KEY_SHOPPER_EMAIL = "shopperEmail";

    public static final String KEY_FIRST_NAME = "firstName";

    public static final String KEY_LAST_NAME = "lastName";

    private String mShopperEmail;

    private String mFirstName;

    private String mLastName;

    private DokuDetails() {
        // Empty constructor for Builder.
    }

    private DokuDetails(@NonNull Parcel in) {
        super(in);

        mShopperEmail = in.readString();
        mFirstName = in.readString();
        mLastName = in.readString();
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(mShopperEmail);
        parcel.writeString(mFirstName);
        parcel.writeString(mLastName);
    }

    @NonNull
    @Override
    public JSONObject serialize() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(KEY_SHOPPER_EMAIL, mShopperEmail);
        jsonObject.put(KEY_FIRST_NAME, mFirstName);
        jsonObject.put(KEY_LAST_NAME, mLastName);
        return jsonObject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DokuDetails that = (DokuDetails) o;

        if (mShopperEmail != null ? !mShopperEmail.equals(that.mShopperEmail) : that.mShopperEmail != null) {
            return false;
        }
        if (mFirstName != null ? !mFirstName.equals(that.mFirstName) : that.mFirstName != null) {
            return false;
        }
        return mLastName != null ? mLastName.equals(that.mLastName) : that.mLastName == null;
    }

    @Override
    public int hashCode() {
        int result = mShopperEmail != null ? mShopperEmail.hashCode() : 0;
        result = 31 * result + (mFirstName != null ? mFirstName.hashCode() : 0);
        result = 31 * result + (mLastName != null ? mLastName.hashCode() : 0);
        return result;
    }

    public static final class Builder {
        private final DokuDetails mDokuDetails;

        public Builder(@NonNull String shopperEmail, @NonNull String firstName, @NonNull String lastName) {
            mDokuDetails = new DokuDetails();
            mDokuDetails.mShopperEmail = shopperEmail;
            mDokuDetails.mFirstName = firstName;
            mDokuDetails.mLastName = lastName;
        }

        @NonNull
        public DokuDetails build() {
            return mDokuDetails;
        }
    }
}
