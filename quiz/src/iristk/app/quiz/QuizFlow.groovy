package iristk.app.quiz

import furhatos.flow.FlowVariable
import furhatos.flow.dialog.DialogState
import furhatos.flow.dialog.Response
import furhatos.flow.dialog.Say

class QuizFlow extends DialogState {

	@FlowVariable
	public Record initialParameters
	@FlowVariable
	public QuestionSet questions
	@FlowVariable
	public Question question
	@FlowVariable
	public int guess
	@FlowVariable
	public int winningScore
	@FlowVariable
	public boolean startedFromSkill
	@FlowVariable
	public boolean allowBargein
	@FlowVariable
	public String originSkill

	void init() {
		// Please initialize all variables you need here. init() will only be called once
		this.initialParameters = null
		this.questions = null
	}
}

class Idle extends State {


	void onEntry() {
		if (system.hasUsers()) {
			trans StartGame
		}
	}

	void onEvent("sense.user.enter") {
		trans StartGame
	}

}


class play extends State {


	void onEntry() {
		if (initialParameters != null && initialParameters.has("originSkill")) {
			originSkill = initialParameters.getString("originSkill");
		}
		startedFromSkill = true;
		trans StartGame
	}


}


class StartGame extends Dialog {


	void onEntry() {
say "Let's play, the Fur hat quiz." 
		system.putUsers("score", 0);
		if (system.getNumUsers() > 1) {
say "The first to reach"			winningScore
 "points is the winner"  "The first to reach"			winningScore
 "points is the winner"
		} else {
say "You win if you reach"			winningScore
 "points!"  "You win if you reach"			winningScore
 "points!"
		}
say "Here comes the first question" 
		question = questions.next();
		trans ReadQuestion
	}


}


class EndGame extends State {


	void onEntry() {
say "Would you like to play again?" 
		Builder builder = new CustomEvent.Builder("keepListening")
		raise builder.buildEvent()
	}

	void onResponse(Response reply) {
		if (reply.contains(yes)) {
say "Great" 
			trans StartGame
		}
		else if (reply.contains(no) || reply.contains(goodbye)) {
say "Okay, goodbye." 
			Builder builder = new CustomEvent.Builder("action.skill")
			builder.setField("entry", originSkill)
			send builder.buildEvent()
		}
	}
	void onEvent("keepListening") {
listen()
		Builder builder = new CustomEvent.Builder("keepListening")
		raise builder.buildEvent()
	}

}


class Dialog extends State {


	void onEntry() {

		void onEvent("sense.user.speech.start") {
			if (system.isAttending(event) && eq(event.get("speakers"), 1)) {
				Builder builder = new CustomEvent.Builder("action.gesture")
				builder.setField("name", "smile")
				send builder.buildEvent()
			}
		}
		void onEvent("sense.user.leave") {
			if (system.isAttending(event) || !system.hasUsers()) {
				if (system.hasUsers()) {
attendRandom()
					trans NextQuestion
				} else {
say "Goodbye" 
					trans Idle
				}
			}
		}

	}


	class NextQuestion extends Dialog {


		void onEntry() {
			question = questions.next(); guess = 0;
			// You had an RANDOM here, it is not supported by the migrator. Please implement your own random.
			// START OF RANDOM
say"<spurt audio=\"free_dialogue/ehm_exh_hesitation_05\">" "ehm""</spurt>"			// You have a CUSTOM TAG (usel/voice/emphasis/spurt) here. It is not fully supported by the migrator, so you will see a few errors here. Remove the extra quotes and you should be good.
			
 "<spurt audio=\"free_dialogue/ehm_exh_hesitation_05\">""</spurt>"			// You have a CUSTOM TAG (usel/voice/emphasis/spurt) here. It is not fully supported by the migrator, so you will see a few errors here. Remove the extra quotes and you should be good.
			

say"<spurt audio=\"free_dialogue/ehm_exh_hesitation_06\">""</spurt>"			// You have a CUSTOM TAG (usel/voice/emphasis/spurt) here. It is not fully supported by the migrator, so you will see a few errors here. Remove the extra quotes and you should be good.
			
 "<spurt audio=\"free_dialogue/ehm_exh_hesitation_06\">""</spurt>"			// You have a CUSTOM TAG (usel/voice/emphasis/spurt) here. It is not fully supported by the migrator, so you will see a few errors here. Remove the extra quotes and you should be good.
			

say"<spurt audio=\"free_dialogue/ehm_exh_hesitation_04\">""</spurt>"			// You have a CUSTOM TAG (usel/voice/emphasis/spurt) here. It is not fully supported by the migrator, so you will see a few errors here. Remove the extra quotes and you should be good.
			
 "<spurt audio=\"free_dialogue/ehm_exh_hesitation_04\">""</spurt>"			// You have a CUSTOM TAG (usel/voice/emphasis/spurt) here. It is not fully supported by the migrator, so you will see a few errors here. Remove the extra quotes and you should be good.
			

say"<spurt audio=\"free_dialogue/ehm_taketurn_01\">""</spurt>"			// You have a CUSTOM TAG (usel/voice/emphasis/spurt) here. It is not fully supported by the migrator, so you will see a few errors here. Remove the extra quotes and you should be good.
			
 "<spurt audio=\"free_dialogue/ehm_taketurn_01\">""</spurt>"			// You have a CUSTOM TAG (usel/voice/emphasis/spurt) here. It is not fully supported by the migrator, so you will see a few errors here. Remove the extra quotes and you should be good.
			

say"<spurt audio=\"free_dialogue/ehm_taketurn_02\">""</spurt>"			// You have a CUSTOM TAG (usel/voice/emphasis/spurt) here. It is not fully supported by the migrator, so you will see a few errors here. Remove the extra quotes and you should be good.
			
 "<spurt audio=\"free_dialogue/ehm_taketurn_02\">""</spurt>"			// You have a CUSTOM TAG (usel/voice/emphasis/spurt) here. It is not fully supported by the migrator, so you will see a few errors here. Remove the extra quotes and you should be good.
			

say"<spurt audio=\"free_dialogue/ehm_hesitation_01\">""</spurt>"			// You have a CUSTOM TAG (usel/voice/emphasis/spurt) here. It is not fully supported by the migrator, so you will see a few errors here. Remove the extra quotes and you should be good.
			
 "<spurt audio=\"free_dialogue/ehm_hesitation_01\">""</spurt>"			// You have a CUSTOM TAG (usel/voice/emphasis/spurt) here. It is not fully supported by the migrator, so you will see a few errors here. Remove the extra quotes and you should be good.
			

say"<spurt audio=\"free_dialogue/ehm_hesitation_02\">""</spurt>"			// You have a CUSTOM TAG (usel/voice/emphasis/spurt) here. It is not fully supported by the migrator, so you will see a few errors here. Remove the extra quotes and you should be good.
			
 "<spurt audio=\"free_dialogue/ehm_hesitation_02\">""</spurt>"			// You have a CUSTOM TAG (usel/voice/emphasis/spurt) here. It is not fully supported by the migrator, so you will see a few errors here. Remove the extra quotes and you should be good.
			

say"<spurt audio=\"free_dialogue/ehm_hesitation_03\">""</spurt>"			// You have a CUSTOM TAG (usel/voice/emphasis/spurt) here. It is not fully supported by the migrator, so you will see a few errors here. Remove the extra quotes and you should be good.
			
 "<spurt audio=\"free_dialogue/ehm_hesitation_03\">""</spurt>"			// You have a CUSTOM TAG (usel/voice/emphasis/spurt) here. It is not fully supported by the migrator, so you will see a few errors here. Remove the extra quotes and you should be good.
			

say"<spurt audio=\"free_dialogue/ehm_hesitation_05\">""</spurt>"			// You have a CUSTOM TAG (usel/voice/emphasis/spurt) here. It is not fully supported by the migrator, so you will see a few errors here. Remove the extra quotes and you should be good.
			
 "<spurt audio=\"free_dialogue/ehm_hesitation_05\">""</spurt>"			// You have a CUSTOM TAG (usel/voice/emphasis/spurt) here. It is not fully supported by the migrator, so you will see a few errors here. Remove the extra quotes and you should be good.
			

say"<spurt audio=\"free_dialogue/ehm_hesitation_06\">""</spurt>"			// You have a CUSTOM TAG (usel/voice/emphasis/spurt) here. It is not fully supported by the migrator, so you will see a few errors here. Remove the extra quotes and you should be good.
			
 "<spurt audio=\"free_dialogue/ehm_hesitation_06\">""</spurt>"			// You have a CUSTOM TAG (usel/voice/emphasis/spurt) here. It is not fully supported by the migrator, so you will see a few errors here. Remove the extra quotes and you should be good.
			

			// END OF RANDOM
			if (system.hasManyUsers()) {
				// You had an RANDOM here, it is not supported by the migrator. Please implement your own random.
				// START OF RANDOM
				// You had an BLOCK here, it is not supported by the migrator. Please implement your own IF/ELSE/SWITCH.
				// START OF BLOCK
attendAll()
say "The next category is"				question.getCategory()
 				question.getCategory()

say "Let's see who answers first" 
				// END OF BLOCK
				// You had an BLOCK here, it is not supported by the migrator. Please implement your own IF/ELSE/SWITCH.
				// START OF BLOCK
attendOther()
				if (system.getCurrentUser().has("name")) {
say "The next one is for you"					system.getCurrentUser().get("name")
 					system.getCurrentUser().get("name")

				}
say "Let's see what you know about"				question.getCategory()
 				question.getCategory()

				// END OF BLOCK
				// END OF RANDOM
			} else {
say "The next category is"				question.getCategory()
 				question.getCategory()

			}
			trans ReadQuestion
		}


	}


	class ReadQuestion extends AwaitAnswer {


		void onEntry() {
			if (allowBargein) {
prompt question.getfullquestion(), context:"default " + question.getId()

			} else {
say question.getFullQuestion()
listen context:"quiz " + question.getid()

			}
		}


	}


	class ReadOptions extends AwaitAnswer {


		void onEntry() {
			if (allowBargein) {
prompt question.getoptions(), context:"default " + question.getId()

			} else {
say question.getOptions()
listen context:"quiz " + question.getid()

			}
		}


	}


	class AwaitAnswer extends Dialog {


		void onEntry() {
listen context:"quiz " + question.getid()

		}

		void onResponse(Response reply) {
			if (reply.contains(goodbye)) {
say "Okay, goodbye." 
				if (startedFromSkill) {
					Builder builder = new CustomEvent.Builder("action.skill")
					builder.setField("entry", originSkill)
					send builder.buildEvent()
				}
			}
			else if (reply.speech.type == SenseSpeechRec.Type.FINAL || reply.speech.type == SenseSpeechRec.Type.MAXSPEECH) {
				if (question.isCorrect(event.get("all:0:sem:answer"))) {
attend target:event.get("all:0:user")

					trans CorrectAnswer
				} else if (question.isCorrect(event.get("all:1:sem:answer"))) {
attend target:event.get("all:1:user")

					trans CorrectAnswer
				} else {
say "None of you were correct, let's try another question." 
					trans NextQuestion
				}
			}
			else if (reply.contains(yes)) {
				// You had an RANDOM here, it is not supported by the migrator. Please implement your own random.
				// START OF RANDOM
say "So, what is your guess?" 
				// END OF RANDOM
				trans AwaitAnswer
			}
			else if (reply.contains(dontknow) || reply.contains(no)) {
				Builder builder = new CustomEvent.Builder("skip")
				raise builder.buildEvent()
			}
			else if (reply.contains(req_repeat)) {
say "Okay" 
				trans ReadQuestion
			}
			else if (reply.contains(req_repeat_options)) {
say "Okay, here are the options" 
				trans ReadOptions
			}
			else if (reply.contains(req_quiz_stop)) {
say "Okay, let's stop playing" 
				trans EndGame
			}
			else if (reply.speech.type == SenseSpeechRec.Type.FINAL || reply.speech.type == SenseSpeechRec.Type.MAXSPEECH) {
				if (system.isAttendingAll()) {
attend target:event.get("user")

				}
				if (question.isCorrect(event.get("sem:answer"))) {
					trans CorrectAnswer
				} else {
					trans IncorrectAnswer
				}
			}
			else if (reply.speech.type == SenseSpeechRec.Type.FINAL || reply.speech.type == SenseSpeechRec.Type.MAXSPEECH) {
attendOther mode:"eyes"

				Builder builder = new CustomEvent.Builder("action.gesture")
				builder.setField("name", "express_disgust")
				send builder.buildEvent()
say "You were not supposed to answer that" 
				if (question.isCorrect(event.get("sem:answer"))) {
say "You also gave away the answer, which is not so smart" 
				}
attendOther mode:"eyes"

say "So, what is your answer?" 
				trans AwaitAnswer
			}
			else {
				Builder builder = new CustomEvent.Builder("skip")
				raise builder.buildEvent()
			}
		}
		void onEvent("skip") {
			if (system.hasManyUsers()) {
attendOther()
say "Maybe you know the answer?" 
				trans AwaitAnswer
			} else {
				// You had an RANDOM here, it is not supported by the migrator. Please implement your own random.
				// START OF RANDOM
say "Come on, make an educated guess" 
say "You could at least try" 
say "Why don't you make a guess" 
				// END OF RANDOM
				trans AwaitAnswer
			}
		}

	}


	class CorrectAnswer extends Dialog {

		public int score = system.getCurrentUser().incrInteger("score")

		void onEntry() {
			system.getCurrentUser().putIfNotNull("score", score);
say "That is correct, you now have a score of"			score
 			score

			if (score >= winningScore) {
				trans Winner
			} else if (score == winningScore - 1) {
				// You had an RANDOM here, it is not supported by the migrator. Please implement your own random.
				// START OF RANDOM
say "You are only one score from winning now" 
say "You only need one point more, and you will win" 
				// END OF RANDOM
				trans CloseToWinning
			} else {
				trans NextQuestion
			}
		}


	}


	class IncorrectAnswer extends Dialog {


		void onEntry() {
say "That was wrong" 
			if (system.hasManyUsers() && guess == 0) {
				guess++;
attendOther()
				// You had an RANDOM here, it is not supported by the migrator. Please implement your own random.
				// START OF RANDOM
say "Maybe you know the answer?" 
say "Do you have a better guess?" 
say "What do you think?" 
				// END OF RANDOM
				trans AwaitAnswer
			}
say "The correct answer was"			question.getCorrectAnswer()
 			question.getCorrectAnswer()

			trans NextQuestion
		}


	}


	class CloseToWinning extends Dialog {


		void onEntry() {
			// You had an RANDOM here, it is not supported by the migrator. Please implement your own random.
			// START OF RANDOM
say "Do you feel nervous?" 
say "Are you nervous?" 
			// END OF RANDOM
listen()
		}

		void onResponse(Response reply) {
			// You had an RANDOM here, it is not supported by the migrator. Please implement your own random.
			// START OF RANDOM
say "I think you are doing great" 
say "I think this is really exciting" 
			// END OF RANDOM
			trans NextQuestion
			else {
				super.onResponse(reply)
			}
		}

	}


	class Winner extends Dialog {


		void onEntry() {
			system.putUsers("score", 0);
			system.getCurrentUser().putIfNotNull("score", 0);
say "Congratulations, you are the winner" 
			if (system.hasManyUsers()) {
attendOther()
say "I am sorry, but you lost." 
			}
			trans EndGame
		}


	}


