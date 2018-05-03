
package com.example.demo.obj;

/**
 *
 * @author vukolov
 */
public class Answer{
        private String answer;

        public Answer(String answer) {
            this.answer = answer;
        }

        public Answer() {
        }

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }

        @Override
        public String toString() {
            return "{\"answer\":\"" + answer + "\"}";
        }
        
    }