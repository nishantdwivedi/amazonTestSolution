public static int getMinScore(int productsNodes, List<Integer> productsFrom, List<Integer> productsTo) {

	Set<Integer> set[] = new HashSet[productsNodes + 1];
	for (int i = 0; i < set.length; i++) {
		set[i] = new HashSet<Integer>();
	}

	for (int i = 0; i < productsFrom.size(); i++) {
		int from = productsFrom.get(i);
		int to = productsTo.get(i);
		set[from].add(to);
		set[to].add(from);
	}

	int result = Integer.MAX_VALUE;
	for (int v = 1; v < set.length; v++) {
		Set<Integer> st = set[v];
		if (st.size() >= 2) {
			List<Integer> list = new ArrayList<>(st);
			for (int i = 0; i < list.size(); i++) {
				int p = list.get(i);
				for (int j = i + 1; j < list.size(); j++) {
					int q = list.get(j);
					if (set[p].contains(q)) {
						int cost = set[v].size() + set[p].size() + set[q].size() - 6;
						result = Math.min(result, cost);
					}

				}

			}

		}
	}
	return result == Integer.MAX_VALUE ? -1 : result;
}
