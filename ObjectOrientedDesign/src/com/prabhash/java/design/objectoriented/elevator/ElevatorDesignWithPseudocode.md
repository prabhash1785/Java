This is a high level object oriented design for an Elevator System. It also includes some of the main pseudocode on how different components will work. This represents simple working structure, it's by no means optimized for a real elevator system.
<br><br>
<b><u>Classes needed for Elevator System:</u></b>
<br><br>
<b>ElevatorManager</b> [Singleton - This is the main elevator program which will manage n elevators in the building]<br>
	<b>Members:</b><br>
		List of Elevator<br>
		Queue of Floor.Request // This maintains request for both directions. One improvement could be to keep two queues, one for each direction but it would increase complexity<br>
		MIN_FLOOR<br>
		MAX_FLOOR<br>
	<b>Operations:</b><br>
		delgate()<br>
		halt() // set whole elevator system in maintenance mode or halt operation<br>
<br><br>
<b>Elevator</b> [Represents individual elevators. There could be n elevators in a building]<br>
	<b>Members:</b><br>
		Queue of Floor // this needs to be sorted so may be a PriorityQueue could be used<br>
		Direction : Enum [Enum of direction - up, down, wait, idle, maintenance]<br>
		CurrentFloor : Floor<br>
	<b>Operations:</b><br>
		operate()<br>
		moveUp()<br>
		moveDown()<br>
		openDoor()<br>
		closeDoor()<br>
		callEmergencyLine()<br>
		getDirection()<br>
		getCurrentFloor()<br>
		setInMaintenanceMode()<br>
<br><br>
<b>Floor</b> [Represents individual floors]<br>
	<b>Members:</b><br>
		eNum of Floors<br>
		class Request {<br>
			currentFloor<br>
			destinationFloor<br>
			Direction [Up, Down]<br>
		}<br>
	<b>Operation:</b><br>
		goUp()<br>
		goDown()<br>

<br>
<b>Some of the main pseudocode for above components:</b></br><br><br>
```
class Floor {
	goUp() {
		ElevatorManager.queue.offer(new Request(currentFloor, destinationFloor, up));
	}	

	goDown() {
		ElevatorManager.queue.offer(new Request(currentFloor, destinationFloor, down));
	}
}

ElevatorManager {
	delegate() {

		// Instead of using one object, we could use a list to track idle and elevators moving in same direction so that these list could be used for next requests in queue
		// but again to simplify pseudocode, I am using single objects instead of lists
		Elevator idleElevator; // track idle elevator
		Elevator elevatorMovingInSameDirection; // elevator moving in same direction as next request in main elevator manager queue 

		while(!halt()) { //keep delegating until powered down or whole system is halted through main controls

			if(queue.peek() != null) {

				Request req = queue.peek();
				boolean startAgain = false; // flag to start from beginning if the request is already pushed to one of the elevators queue during iterating elevators

				for(Elevator elevator : elevators) {

					// first find if there is an elevator at current floor going in same direction as current request in queue
					if(req.currentFloor == elevator.currentFloor && req.direction == elevator.direction) {
						elevator.queue.offer(req.destinationFloor);
						queue.poll(); // remove this request from Elevator Manager queue
						
						startAgain = true;
						break;
					}

					// check if this elevator is idle
					if(elevator.direction == "idle")) {
						idleElevator = elevator; // For this simple design, I am ok to overwrite idle elevator value and instead get the latest idle elevatior
					}

					// check if this elevator is moving in desired direction and elevator's current floor is behind desired floor in queue
					if(elevator.direction == req.direction) {

						// Make sure elevators moving in same direction should also be behind the floor where request is made
						if(req.direction == "Up" && req.currentFloor - elevator.currentFloor > 0) {
							
							elevatorMovingInSameDirection = elevator; // Same as above, it's ok to get this overwritten and instead get the latest elevator moving in same 		direction
						}

						// Make sure elevators moving in same direction should also be behind the floor where request is made
						if(req.direction == "Down" && req.currentFloor - elevator.currentFloor < 0) {
							elevatorMovingInSameDirection = elevator;
						}
					}

				}

				// Only delegate to other floors if you could not find elevator going in same direction at same floor from where the request was made
				if(!startAgain && idleElevator != null) {
					idleElevator.queue.offer(req.destinationFloor);
					queue.poll();
				}
				
				// if we could neither find elevator at current floor nor idle elevator then send this request to elevator behind current Floor and moving in same direction as the request
				if(!startAgain && elevatorMovingInSameDirection != null) {
					elevatorMovingInSameDirection.queue.offer(req.destinationFloor);
					queue.poll();
				}


			}
		}
	}
}


Elevator {

	moveUp() {
		this.currentFloor += 1;
	}

	moveDown() {
		this.currentFloor -= 1;
	}
	
	operate() {

		while(queue.peek() != null) {

			Floor nextFloorInQueue = queue.peek();

			while(this.currentFloor != nextFloorInQueue.request.destinationFloor) {
				if(this.direction == "Up") {
					moveUp();
				} else if(this.direction == "down") {
					moveDown();
				}
			}

			queue.poll(); // remove the request from queue
			open(); //open door

			Direction backUpDirection = this.direction; //back up elevators direction to retrieve it later once dooor closes
			this.direction = "idle"; // set state to idle to let elevatorManager know that requests at current floor could be offered to this elevator queue

			Thread.sleep(10000); // sleep for 10 seconds so that people can leave elevator

			close(); // once people are out close door to move to next floor in queue
			this.direction = backUpDirection;
		}

		this.direction = "idle"; // once queue is empty set the direction to idle
	}
}
```
