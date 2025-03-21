class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashMap<String, List<String>> graph = new HashMap<>();
        HashMap<String, Integer> indegree = new HashMap<>();

        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            indegree.put(recipe, 0);  // Ensure all recipes are initialized
            
            for (String ing : ingredients.get(i)) {
                graph.putIfAbsent(ing, new ArrayList<>());
                graph.get(ing).add(recipe);
                indegree.put(recipe, indegree.getOrDefault(recipe, 0) + 1);
            }
        }

        Queue<String> q = new LinkedList<>();
        for(String sup: supplies){
            q.add(sup);
        }
        HashSet<String> made = new HashSet<>();
        while(!q.isEmpty()){
            String curr = q.poll();

            if (!graph.containsKey(curr)) continue;

            for(String nbrs: graph.get(curr)){
                indegree.put(nbrs, indegree.get(nbrs) - 1);
                if(indegree.get(nbrs) == 0){
                    indegree.remove(nbrs);
                    q.add(nbrs);
                    made.add(nbrs);
                }
            }
        }

        List<String> ls = new ArrayList<>();
        for(String s: recipes){
            if(made.contains(s)){
                ls.add(s);
            }
        }
        return ls;
    }
}