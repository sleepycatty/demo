package com.somegroup.cardfeed.util;

import com.somegroup.cardfeed.model.Customer;

public interface Condition {

	boolean test(Customer cust);
}
