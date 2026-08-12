package com.cvalcoding.sample_project_javafx.model.dao;

import java.util.List;

public abstract class Dao<T> {

	/**
	 * List all object
	 *
	 * @return object list
	 */
	public abstract List<T> getAll();

	/**
	 * Get object by id
	 *
	 * @param id params for object
	 * @return object single
	 */
	public abstract T getById(long id);

	/**
	 *
	 * @param t object params
	 */
	public abstract void create(T t);

	/**
	 *
	 * @param t object params
	 */
	public abstract void update(T t);

	/**
	 *
	 * @param t object params
	 */
	public abstract void delete(T t);


}
