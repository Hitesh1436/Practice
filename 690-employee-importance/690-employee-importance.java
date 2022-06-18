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
        Map<Integer, Employee> map = new HashMap<>();
        for(Employee e : employees)
            map.put(e.id, e);
        
        if(map.get(id) == null)
            return ans;
        
        //if no suboridnates
        if(map.get(id).subordinates == null || map.get(id).subordinates.size() == 0)
            return map.get(id).importance;
        
        //bfs
        Queue<Employee> q = new LinkedList<>();
        q.add(map.get(id));
        while(!q.isEmpty()) {
            Employee e = q.remove();
            ans += e.importance;
			//add all subordinates
            for(int i : e.subordinates)
                q.add(map.get(i));
        }
        
        return ans;
    }
}