import java.util.Queue;
import java.util.Stack;


public class HtmlValidator {

	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {
		Stack<HtmlTag> stack = new Stack<>();

		while (!tags.isEmpty()) {
			HtmlTag currentTag = tags.poll();
			if (currentTag.isOpenTag() && !currentTag.isSelfClosing()) {
				stack.push(currentTag);
			} else {
				if (!currentTag.isSelfClosing()) {
					if (stack.isEmpty()) {
						return null;
					} else {
						HtmlTag topTag = stack.pop();
						if (!topTag.matches(currentTag)) {
							stack.push(topTag);
							return stack;
						}
					}
				}
			}
		}
		if (stack.isEmpty()) {
			return new Stack<>();
		} else {
			return stack;
		}
	}
}