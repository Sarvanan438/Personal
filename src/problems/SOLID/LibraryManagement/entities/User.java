package problems.SOLID.LibraryManagement.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class User implements Id {
	private Id userId;
	private String name;
	private LocalDate registeredOn,updatedOn;


	public User(Id userId, String name) {
		this.userId = userId;
		this.name = name;
	}

	public User(Id userId, String name, LocalDate registeredOn) {
		this.userId = userId;
		this.name = name;
		this.registeredOn = registeredOn;
	}



	public String getName() {
		return name;
	}

	public LocalDate getRegisteredOn() {
		return registeredOn;
	}

	public LocalDate getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDate updatedOn) {
		this.updatedOn = updatedOn;
	}
	public void updateTime(){
		this.setUpdatedOn(LocalDate.now());
	}
	public void setName(String name) {
		this.name = name;
		this.updateTime();
	}



	@Override
	public String getId() {
		return this.userId.getId();
	}

	@Override
	public void setId(String id) {
		this.userId.setId(id);
	}
	@Override
	public boolean isEqual(Id id) {
		return this.userId.isEqual(id);
	}

	@Override
	public String toString() {
		return "User{" +
				"userId=" + userId.getId() +
				", name='" + name + '\'' +
				", registeredOn=" + registeredOn +
				'}';
	}
}
