package com.prabhash.java.interview.ch4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A Choose Your Own Adventure Book is a type of book where readers are periodically given various choices that dictates
 * where the story can go. 
 * 
 * For example, you start at chapter A. At the end of chapter A, you’re presented with a couple of options. If you choose option 1, go 
 * to chapter B. If you choose option 2, go to chapter C. Each choice leads to more and more choices and eventually to an ending. 
 * Readers can also re-read the book, make different choices and follow a different path to a different ending. 
 * 
 * Chapter: options
 * A: B, C
 * B: D
 * C: D
 * 
 * Design this book.
 * 
 * @author Prabhash Rathore
 *
 */
public class ChooseYourAdventure {
	
	private Chapter first;
	
	public ChooseYourAdventure(Chapter first) {
		this.first = first;
	}
	
	/**
	 * Get all possible stories in a book.
	 * 
	 * Time Complexity: O(n)
	 * 
	 * @return List<List<Chapter>>
	 */
	public List<List<Chapter>> getAllStories() {
		if(first == null) {
			return null;
		}
		
		List<List<Chapter>> stories = new ArrayList<>();
		List<Chapter> story = new ArrayList<>();
		
		getAllStoriesHelper(first, story, stories);
		return stories;
	}
	
	private void getAllStoriesHelper(Chapter root, List<Chapter> story, List<List<Chapter>> stories) {
		if(root == null) {
			return;
		}
		
		story.add(root); // Make sure to add the original root node to story
		
		if(root.nextChapters == null || root.nextChapters.size() == 0) {
			// Don't add same object to list, this will corrupt the collection. Instead copy data into a new list and add that
			// to main collection
			stories.add(new ArrayList<>(story)); 
			return;
		}
		
		List<Chapter> nextChapters = root.nextChapters;
		for(Chapter chapter : nextChapters) {
			getAllStoriesHelper(chapter, story, stories);
			story.remove(chapter); // make sure to remove last chapter from list to prevent duplication
		}
	}
	
	/**
	 * Find if book has cyclic references.
	 * 
	 * Time Complexity: O(n)
	 * 
	 * @return boolean
	 */
	public boolean hasCycle() {
		if(first == null) {
			return false;
		}
		
		Set<Chapter> set = new HashSet<>();
		return hasCycleHelper(first, set);
	}
	
	private boolean hasCycleHelper(Chapter root, Set<Chapter> set) {
		if(root == null) {
			return false;
		}
		
		if(set.contains(root)) { // Check if set already contains the same physical object, if it does it has cycles
			return true;
		}
		
		set.add(root);
		List<Chapter> nextChapters = root.nextChapters;
		for(Chapter chapter : nextChapters) {
			boolean result = hasCycleHelper(chapter, set);
			if(result) {
				return true;
			}
			set.remove(chapter);
		}
		
		return false;
	}
	
	public static class Chapter {
		private String chapterName;
		private List<Chapter> nextChapters;
		
		public Chapter(String chapterName) {
			this.chapterName = chapterName;
			nextChapters = new ArrayList<>();
		}
		
		@Override
		public String toString() {
			return this.chapterName;
		}
	}
	
	public static ChooseYourAdventure generateYoruBook() {
		ChooseYourAdventure book = new ChooseYourAdventure(new Chapter("A"));
		book.first.nextChapters = Arrays.asList(new Chapter("B"), new Chapter("C"));
		
		Chapter d = new Chapter("D");
		book.first.nextChapters.get(0).nextChapters = Arrays.asList(d);
		book.first.nextChapters.get(1).nextChapters = Arrays.asList(d);
		
		return book;
	}

	public static void main(String[] args) {
		ChooseYourAdventure book = generateYoruBook();
		
		List<List<Chapter>> allStories = book.getAllStories();
		System.out.println("Here all the stories in the book:");
		for(List<Chapter> list : allStories) {
			for(Chapter c : list) {
				System.out.print(c + " -> ");
			}
			System.out.print("\n");
		}
		
		// create a book with cycle
		Chapter z = new Chapter("Z");
		ChooseYourAdventure book2 = new ChooseYourAdventure(z);
		book2.first.nextChapters = Arrays.asList(z);
		System.out.println("Does book2 have cycles: " + book2.hasCycle());
	}
}
