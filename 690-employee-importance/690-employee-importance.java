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
        int ans = 0;
        //Map of id vs Employee
        Map<Integer, Employee> emp = new HashMap<>();
        for(Employee e : employees)
            emp.put(e.id, e);
        
        if(emp.get(id) == null)
            return ans;
        
        //if no suboridnates
        if(emp.get(id).subordinates == null || emp.get(id).subordinates.size() == 0)
            return emp.get(id).importance;
        
        //bfs
        Queue<Employee> q = new LinkedList<>();
        q.add(emp.get(id));
        while(!q.isEmpty()) {
            Employee e = q.poll();
            ans += e.importance;
			//add all subordinates
            for(int i : e.subordinates)
                q.add(emp.get(i));
        }
        
        return ans;
    }
}