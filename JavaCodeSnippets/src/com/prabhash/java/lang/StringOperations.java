package com.prabhash.java.lang;

public class StringOperations {

	private String s = "holiday";
	
	public void stringComparison() {
		
		if("abc" == "abc") {
			System.out.println("== operation alllowed on String objects");
		}
		else {
			System.out.println("Result is false..");	
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((s == null) ? 0 : s.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StringOperations other = (StringOperations) obj;
		if (s == null) {
			if (other.s != null)
				return false;
		} else if (!s.equals(other.s))
			return false;
		return true;
	}
	
	
	
	public static void main(String[] args) {
		
		new StringOperations().stringComparison();
	}
	
}
	
