package be.envano.edged;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class PromptDocumentFilter extends DocumentFilter {

    private final String prompt;

    public PromptDocumentFilter(String prompt) {
        this.prompt = prompt;
    }

    @Override
    public void remove(
      FilterBypass filterBypass,
      int offset,
      int length
    ) throws BadLocationException {
        if (offset < prompt.length()) {
            int end = offset + length;
            if (end <= prompt.length()) {
                return;
            }
            int newLength = end - prompt.length();
            super.remove(filterBypass, prompt.length(), newLength);
        } else {
            super.remove(filterBypass, offset, length);
        }
    }

    @Override
    public void replace(
      FilterBypass filterBypass,
      int offset,
      int length,
      String text,
      AttributeSet attributeSet
    ) throws BadLocationException {
        if (offset < prompt.length()) {
            int end = offset + length;
            if (end <= prompt.length()) {
                return;
            }
            int newOffset = prompt.length();
            int newLength = end - prompt.length();
            super.replace(filterBypass, newOffset, newLength, text, attributeSet);
        } else {
            super.replace(filterBypass, offset, length, text, attributeSet);
        }
    }

}
