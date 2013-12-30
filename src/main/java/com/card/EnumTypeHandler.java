package com.card;

import com.ibatis.sqlmap.client.extensions.ParameterSetter;
import com.ibatis.sqlmap.client.extensions.ResultGetter;
import com.ibatis.sqlmap.client.extensions.TypeHandlerCallback;

import java.sql.SQLException;
import java.sql.Types;

/**
 * User: jitse
 * Date: 9/29/13
 * Time: 9:23 AM
 */
public class EnumTypeHandler implements TypeHandlerCallback {
    public Object getResult(ResultGetter getter) throws SQLException {
        String value = getter.getString();
        if (getter.wasNull() || value.trim().length()==0)  // Treat empty strings as null
        {
            return null;
        }

        if (value.equalsIgnoreCase("coupon")) {
            return AttachmentType.COUPON;
        } else {
            return AttachmentType.CARD;
        }
    }

    public void setParameter(ParameterSetter setter, Object parameter)
            throws SQLException {
        if (parameter == null) {
            setter.setNull(Types.VARCHAR);
        } else {
            AttachmentType r = (AttachmentType)parameter;
            if (r == AttachmentType.CARD) {
                setter.setString("card");
            } else {
                setter.setString("coupon");
            }
        }
    }

    public Object valueOf(String s) {
        return s;
    }
}
