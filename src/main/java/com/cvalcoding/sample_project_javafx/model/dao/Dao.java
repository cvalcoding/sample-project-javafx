package com.cvalcoding.sample_project_javafx.model.dao;

import java.util.List;

public abstract class Dao<T> {

	/**
	 * List all object
	 *
	 * @return
	 */
	public abstract List<T> getAll();

	/**
	 * Get object by id
	 *
	 * @param id
	 * @return
	 */
	public abstract T get(long id);

	/**
	 *
	 * @param t
	 */
	public abstract void add(T t);

	/**
	 *
	 * @param t
	 */
	public abstract void update(T t);

	/**
	 *
	 * @param t
	 */
	public abstract void remove(T t);


}
