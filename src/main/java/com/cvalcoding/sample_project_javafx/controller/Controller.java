package com.cvalcoding.sample_project_javafx.controller;

import java.util.HashMap;
import java.util.List;

abstract public class Controller<T> {

	/**
	 *
	 * @return list object
	 */
	abstract public List<T> index();

	/**
	 *
	 * @param id parameter
	 * @return object
	 */
	abstract public T show(long id);

	/**
	 *
	 * @param dataMap element for create
	 */
	abstract public void create(HashMap<String, String> dataMap);

	/**
	 *
	 * @param dataMap element for edit
	 */
	abstract public void edit(HashMap<String, String> dataMap);

	/**
	 *
	 * @param t object for delete
	 */
	abstract public void destroy(T t);
}
