/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
	public int getImportance(List<Employee> employees, int id) {
		// Do some preprocessing to avoid the search time complexity for each ID, so make a HasMap of [ID -> Employee]
		HashMap<Integer,Employee> map=new HashMap<>();
		for(int i=0;i<employees.size();i++){
			map.put(employees.get(i).id,employees.get(i)); // ID->Emp
		}
		return getans(map,id);
	}
	public int getans(HashMap<Integer, Employee> map,int id){
		// Recursively get the ans for each id
		Employee rp=map.get(id); 
		if(rp.subordinates.size()==0){ // base case !
			return rp.importance;
		}
		int ans=0;
		List<Integer> child=rp.subordinates;
		for(int i=0;i<child.size();i++){
			ans+=getans(map,child.get(i)); // get ans for child IDs
		}

		return rp.importance+ans; // Add my importance to child IDs
	}
}