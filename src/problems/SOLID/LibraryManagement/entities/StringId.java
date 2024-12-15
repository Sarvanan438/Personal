package problems.SOLID.LibraryManagement.entities;

public class StringId implements  Id{
	String id;

	public StringId(String id){
		this.id=id;
	}
	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public void setId(String id) {
		this.id=id;
	}
	@Override
	public boolean isEqual(Id id) {
		return this.id.equals(id.getId());
	}
}
