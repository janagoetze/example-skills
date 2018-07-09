package furhatos.app.quiz

import furhatos.flow.kotlin.*
import furhatos.nlu.common.*

var initialParameters : Record? = null
var questions : QuestionSet? = null
var question : Question = null
var guess : int = 0
var winningScore : int = 3
var startedFromSkill : boolean = false
var allowBargein : boolean = false
var originSkill : String = 'iristk.furhat.server.IdleSkill'


val Idle : State = state {

	var stateVariable : int = 3

	onEntry {
furhat.attend(target:"bajs"
)
furhat.say 		originSkill
(		originSkill
)
furhat.say ()
		system.getUsers().forEach {
			// Use the variable -> it <- instead of handler.getItem() here
		}
		if (system.hasUsers()) {
			goto(StartGame)
		}
	}

	onEvent<sense.user.enter> {
		goto(StartGame)
	}

}


val play : State = state {


	onEntry {
		if (initialParameters != null && initialParameters.has("originSkill")) {
			originSkill = initialParameters.getString("originSkill");
		}
		startedFromSkill = true;
		goto(StartGame)
	}


}


val StartGame : State = state(Dialog) {


	onEntry {
furhat.say ()
		system.putUsers("score", 0);
		if (system.getNumUsers() > 1) {
furhat.say 			winningScore
 ( 			winningScore
 )
		} else {
furhat.say 			winningScore
 ( 			winningScore
 )
		}
furhat.say ()
		question = questions.next();
		goto(ReadQuestion)
	}


}


val EndGame : State = state {


	onEntry {
furhat.say ()
		Builder builder = CustomEvent.Builder("keepListening")
		raise(builder.buildEvent())
	}

onResponse	(reply.contains(yes)) {
furhat.say ()
		goto(StartGame)
	}
onResponse	(reply.contains(no) || reply.contains(goodbye)) {
furhat.say ()
		Builder builder = CustomEvent.Builder("action.skill")
		builder.setField("entry", originSkill)
		send(builder.buildEvent())
	}
	onEvent<keepListening> {
furhat.listen()
		Builder builder = CustomEvent.Builder("keepListening")
		raise(builder.buildEvent())
	}

}


val Dialog : State = state {


	onEntry {

		onEvent<sense.user.speech.start> {
			if (system.isAttending(event) && eq(event.get("speakers"), 1)) {
				Builder builder = CustomEvent.Builder("action.gesture")
				builder.setField("name", "smile")
				send(builder.buildEvent())
			}
		}
		onEvent<sense.user.leave> {
			if (system.isAttending(event) || !system.hasUsers()) {
				if (system.hasUsers()) {
furhat.attendRandom()
					goto(NextQuestion)
				} else {
furhat.say ()
					goto(Idle)
				}
			}
		}

	}


	val NextQuestion : State = state(Dialog) {


		onEntry {
			question = questions.next(); guess = 0;
			random(
{ furhat.say"<spurt audio=\"free_dialogue/ehm_exh_hesitation_05\">" "</spurt>"			// You have a CUSTOM TAG (usel/voice/emphasis/spurt) here. It is not fully supported by the migrator, so you will see a few errors here. Remove the extra quotes and you should be good.
			
("<spurt audio=\"free_dialogue/ehm_exh_hesitation_05\">""</spurt>"			// You have a CUSTOM TAG (usel/voice/emphasis/spurt) here. It is not fully supported by the migrator, so you will see a few errors here. Remove the extra quotes and you should be good.
			
)
furhat.say"<spurt audio=\"free_dialogue/ehm_exh_hesitation_06\">""</spurt>"			// You have a CUSTOM TAG (usel/voice/emphasis/spurt) here. It is not fully supported by the migrator, so you will see a few errors here. Remove the extra quotes and you should be good.
			
("<spurt audio=\"free_dialogue/ehm_exh_hesitation_06\">""</spurt>"			// You have a CUSTOM TAG (usel/voice/emphasis/spurt) here. It is not fully supported by the migrator, so you will see a few errors here. Remove the extra quotes and you should be good.
			
)
furhat.say"<spurt audio=\"free_dialogue/ehm_exh_hesitation_04\">""</spurt>"			// You have a CUSTOM TAG (usel/voice/emphasis/spurt) here. It is not fully supported by the migrator, so you will see a few errors here. Remove the extra quotes and you should be good.
			
("<spurt audio=\"free_dialogue/ehm_exh_hesitation_04\">""</spurt>"			// You have a CUSTOM TAG (usel/voice/emphasis/spurt) here. It is not fully supported by the migrator, so you will see a few errors here. Remove the extra quotes and you should be good.
			
)
furhat.say"<spurt audio=\"free_dialogue/ehm_taketurn_01\">""</spurt>"			// You have a CUSTOM TAG (usel/voice/emphasis/spurt) here. It is not fully supported by the migrator, so you will see a few errors here. Remove the extra quotes and you should be good.
			
("<spurt audio=\"free_dialogue/ehm_taketurn_01\">""</spurt>"			// You have a CUSTOM TAG (usel/voice/emphasis/spurt) here. It is not fully supported by the migrator, so you will see a few errors here. Remove the extra quotes and you should be good.
			
)
furhat.say"<spurt audio=\"free_dialogue/ehm_taketurn_02\">""</spurt>"			// You have a CUSTOM TAG (usel/voice/emphasis/spurt) here. It is not fully supported by the migrator, so you will see a few errors here. Remove the extra quotes and you should be good.
			
("<spurt audio=\"free_dialogue/ehm_taketurn_02\">""</spurt>"			// You have a CUSTOM TAG (usel/voice/emphasis/spurt) here. It is not fully supported by the migrator, so you will see a few errors here. Remove the extra quotes and you should be good.
			
)
furhat.say"<spurt audio=\"free_dialogue/ehm_hesitation_01\">""</spurt>"			// You have a CUSTOM TAG (usel/voice/emphasis/spurt) here. It is not fully supported by the migrator, so you will see a few errors here. Remove the extra quotes and you should be good.
			
("<spurt audio=\"free_dialogue/ehm_hesitation_01\">""</spurt>"			// You have a CUSTOM TAG (usel/voice/emphasis/spurt) here. It is not fully supported by the migrator, so you will see a few errors here. Remove the extra quotes and you should be good.
			
)
furhat.say"<spurt audio=\"free_dialogue/ehm_hesitation_02\">""</spurt>"			// You have a CUSTOM TAG (usel/voice/emphasis/spurt) here. It is not fully supported by the migrator, so you will see a few errors here. Remove the extra quotes and you should be good.
			
("<spurt audio=\"free_dialogue/ehm_hesitation_02\">""</spurt>"			// You have a CUSTOM TAG (usel/voice/emphasis/spurt) here. It is not fully supported by the migrator, so you will see a few errors here. Remove the extra quotes and you should be good.
			
)
furhat.say"<spurt audio=\"free_dialogue/ehm_hesitation_03\">""</spurt>"			// You have a CUSTOM TAG (usel/voice/emphasis/spurt) here. It is not fully supported by the migrator, so you will see a few errors here. Remove the extra quotes and you should be good.
			
("<spurt audio=\"free_dialogue/ehm_hesitation_03\">""</spurt>"			// You have a CUSTOM TAG (usel/voice/emphasis/spurt) here. It is not fully supported by the migrator, so you will see a few errors here. Remove the extra quotes and you should be good.
			
)
furhat.say"<spurt audio=\"free_dialogue/ehm_hesitation_05\">""</spurt>"			// You have a CUSTOM TAG (usel/voice/emphasis/spurt) here. It is not fully supported by the migrator, so you will see a few errors here. Remove the extra quotes and you should be good.
			
("<spurt audio=\"free_dialogue/ehm_hesitation_05\">""</spurt>"			// You have a CUSTOM TAG (usel/voice/emphasis/spurt) here. It is not fully supported by the migrator, so you will see a few errors here. Remove the extra quotes and you should be good.
			
)
furhat.say"<spurt audio=\"free_dialogue/ehm_hesitation_06\">""</spurt>"			// You have a CUSTOM TAG (usel/voice/emphasis/spurt) here. It is not fully supported by the migrator, so you will see a few errors here. Remove the extra quotes and you should be good.
			
("<spurt audio=\"free_dialogue/ehm_hesitation_06\">""</spurt>"			// You have a CUSTOM TAG (usel/voice/emphasis/spurt) here. It is not fully supported by the migrator, so you will see a few errors here. Remove the extra quotes and you should be good.
			
)
 }			)
			if (system.hasManyUsers()) {
				random(
{ 				// You had an BLOCK here, it is not supported by the migrator. Please implement your own IF/ELSE/SWITCH.
				// START OF BLOCK
furhat.attendAll()
furhat.say 				question.getCategory()
(				question.getCategory()
)
furhat.say ()
				// END OF BLOCK
				// You had an BLOCK here, it is not supported by the migrator. Please implement your own IF/ELSE/SWITCH.
				// START OF BLOCK
furhat.attendOther()
				if (system.getCurrentUser().has("name")) {
furhat.say 					system.getCurrentUser().get("name")
(					system.getCurrentUser().get("name")
)
				}
furhat.say 				question.getCategory()
(				question.getCategory()
)
				// END OF BLOCK
 }				)
			} else {
furhat.say 				question.getCategory()
(				question.getCategory()
)
			}
			goto(ReadQuestion)
		}


	}


	val ReadQuestion : State = state(AwaitAnswer) {


		onEntry {
			if (allowBargein) {
furhat.prompt(question.getfullquestion(), context:"default " + question.getId()
)
			} else {
furhat.say(question.getFullQuestion())
furhat.listen(context:"quiz " + question.getid()
)
			}
		}


	}


	val ReadOptions : State = state(AwaitAnswer) {


		onEntry {
			if (allowBargein) {
furhat.prompt(question.getoptions(), context:"default " + question.getId()
)
			} else {
furhat.say(question.getOptions())
furhat.listen(context:"quiz " + question.getid()
)
			}
		}


	}


	val AwaitAnswer : State = state(Dialog) {


		onEntry {
furhat.listen(context:"quiz " + question.getid()
)
		}

onResponse		(reply.contains(goodbye)) {
furhat.say ()
			if (startedFromSkill) {
				Builder builder = CustomEvent.Builder("action.skill")
				builder.setField("entry", originSkill)
				send(builder.buildEvent())
			}
		}
onResponse		{
			if (question.isCorrect(event.get("all:0:sem:answer"))) {
furhat.attend(target:event.get("all:0:user")
)
				goto(CorrectAnswer)
			} else if (question.isCorrect(event.get("all:1:sem:answer"))) {
furhat.attend(target:event.get("all:1:user")
)
				goto(CorrectAnswer)
			} else {
furhat.say ()
				goto(NextQuestion)
			}
		}
onResponse		(reply.contains(yes)) {
			random(
{ furhat.say ()
 }			)
			goto(AwaitAnswer)
		}
onResponse		(reply.contains(dontknow) || reply.contains(no)) {
			Builder builder = CustomEvent.Builder("skip")
			raise(builder.buildEvent())
		}
onResponse		(reply.contains(req_repeat)) {
furhat.say ()
			goto(ReadQuestion)
		}
onResponse		(reply.contains(req_repeat_options)) {
furhat.say ()
			goto(ReadOptions)
		}
onResponse		(reply.contains(req_quiz_stop)) {
furhat.say ()
			goto(EndGame)
		}
onResponse		{
			if (system.isAttendingAll()) {
furhat.attend(target:event.get("user")
)
			}
			if (question.isCorrect(event.get("sem:answer"))) {
				goto(CorrectAnswer)
			} else {
				goto(IncorrectAnswer)
			}
		}
onResponse		{
furhat.attendOther(mode:"eyes"
)
			Builder builder = CustomEvent.Builder("action.gesture")
			builder.setField("name", "express_disgust")
			send(builder.buildEvent())
furhat.say ()
			if (question.isCorrect(event.get("sem:answer"))) {
furhat.say ()
			}
furhat.attendOther(mode:"eyes"
)
furhat.say ()
			goto(AwaitAnswer)
		}
onNoResponse		{
			Builder builder = CustomEvent.Builder("skip")
			raise(builder.buildEvent())
		}
		onEvent<skip> {
			if (system.hasManyUsers()) {
furhat.attendOther()
furhat.say ()
				goto(AwaitAnswer)
			} else {
				random(
{ furhat.say ()
furhat.say ()
furhat.say ()
 }				)
				goto(AwaitAnswer)
			}
		}

	}


	val CorrectAnswer : State = state(Dialog) {

		var score : int = system.getCurrentUser().incrInteger("score")

		onEntry {
			system.getCurrentUser().putIfNotNull("score", score);
furhat.say 			score
(			score
)
			if (score >= winningScore) {
				goto(Winner)
			} else if (score == winningScore - 1) {
				random(
{ furhat.say ()
furhat.say ()
 }				)
				goto(CloseToWinning)
			} else {
				goto(NextQuestion)
			}
		}


	}


	val IncorrectAnswer : State = state(Dialog) {


		onEntry {
furhat.say ()
			if (system.hasManyUsers() && guess == 0) {
				guess++;
furhat.attendOther()
				random(
{ furhat.say ()
furhat.say ()
furhat.say ()
 }				)
				goto(AwaitAnswer)
			}
furhat.say 			question.getCorrectAnswer()
(			question.getCorrectAnswer()
)
			goto(NextQuestion)
		}


	}


	val CloseToWinning : State = state(Dialog) {


		onEntry {
			random(
{ furhat.say ()
furhat.say ()
 }			)
furhat.listen()
		}

onResponse		{
			random(
{ furhat.say ()
furhat.say ()
 }			)
			goto(NextQuestion)
		}

	}


	val Winner : State = state(Dialog) {


		onEntry {
			system.putUsers("score", 0);
			system.getCurrentUser().putIfNotNull("score", 0);
furhat.say ()
			if (system.hasManyUsers()) {
furhat.attendOther()
furhat.say ()
			}
			goto(EndGame)
		}


	}


