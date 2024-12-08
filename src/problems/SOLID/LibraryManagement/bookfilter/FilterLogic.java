package problems.SOLID.LibraryManagement.bookfilter;

import problems.SOLID.LibraryManagement.Conditions;

/**
 * This is an ds that contains the Filter commands in specfic terms
 * This works well for those that can be easily fit into this grouping
 * Complex queries will have the repository handle it
 */
public class FilterLogic {
	private String property;
	private Conditions condition; // e.g., "CONTAINS", "EQUALS"
	private String value;
	private FilterLogic nextFilterLogic = null;
	public FilterLogic(String property, Conditions condition, String value) {
		this.property = property;
		this.condition = condition;
		this.value = value;
	}

	public FilterLogic(String property, Conditions condition, String value, FilterLogic nextFilterLogic) {
		this(property,condition,value);
		this.nextFilterLogic = nextFilterLogic;
	}

	public String getProperty() {
		return property;
	}

	public Conditions getCondition() {
		return condition;
	}

	public String getValue() {
		return value;
	}

	public boolean hasNextFilterLogic(){
		return this.nextFilterLogic !=null;
	}

	public FilterLogic nextFilterLogic(){
		return this.nextFilterLogic;
	}

	public  void setNextFilterLogic(FilterLogic logic){
		this.nextFilterLogic=logic;
	}

}
