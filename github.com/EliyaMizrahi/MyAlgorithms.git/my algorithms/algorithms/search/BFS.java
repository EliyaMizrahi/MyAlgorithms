package algorithms.search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * The BFS<T> program implements an application that use BFS algorithm
 * 
 * @author Eliya Mizrahi
 * @version 1.0
 * @since 26-08-2015
 *
 */
public class BFS<T> extends CommonSearcher<T> {

	/**
	 * This method is used to solve the problem with the BFS algorithm.
	 * 
	 * @param s-
	 *            represent a Searchable
	 * @return Solution<T> this returns the stack of parents path
	 */
	public Solution<T> search(Searchable<T> s) {
		addToOpenList(s.getStartState());
		HashSet<State<T>> closedSet = new HashSet<State<T>>();

		// do while the open list is not empty
		while (openList.size() > 0) {
			State<T> n = popOpenList();
			closedSet.add(n);

			// if the state is our goal
			if (n.equals(s.getGoalState()))
				return backTrace(n, s.getStartState());

			ArrayList<State<T>> successors = s.getAllPossibleStates(n);

			for (State<T> state : successors) {

				if (!closedSet.contains(state) && !openListContains(state)) {

					state.setCameFrom(n);
					state.setCost(calculateCost(n, s));

					addToOpenList(state);

				} else {
					if (state.getCameFrom() != null && n.getCost() < state.getCameFrom().getCost()) {

						state.setCameFrom(n);
						state.setCost(calculateCost(n, s));

						if (!openListContains(state)) {
							addToOpenList(state);
						} else {

							// removeFromOpenList(state);
							addToOpenList(state);
						}
					}
				}
			}
		}

		return null;
	}

	@Override
	/**
	 * This method is used to calculate the sum of state cost and edge cost
	 * 
	 * @param state
	 * @param search-
	 *            represent a Searchable
	 * @return double this returns the total sum
	 */
	protected double calculateCost(State<T> state, Searchable<T> search) {
		return state.getCost() + search.getMoveCost();
	}

}
