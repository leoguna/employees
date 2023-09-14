package com.javatpoint.repository;

import java.util.List;

public interface Fetch<Z, X> {
	List<X> fetchDataForEntity(Z entity);
}
