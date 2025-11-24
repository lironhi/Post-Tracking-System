# Post-Tracking-System

A sophisticated postal package tracking and distribution network simulator built in Java, featuring real-time visualization, concurrent operations, and multiple design pattern implementations.

![Post Tracking System Demo](tracking%20pack%20system.png)

## Overview

This project simulates a complete postal delivery network with a central Hub, multiple regional Branches, and various vehicle types. It demonstrates real-time package tracking from sender to recipient with visual feedback and comprehensive status monitoring.

## Key Features

- **Real-Time Simulation**: Watch packages move through the delivery network in real-time
- **Multi-Threaded Architecture**: Concurrent execution of Hub, Branches, Trucks, and Vans
- **Visual Network Representation**: Interactive GUI showing the entire distribution network
- **Package Tracking**: Complete tracking history for each package from creation to delivery
- **Flexible Configuration**: Customizable number of branches, trucks, and packages
- **Priority System**: Support for LOW, STANDARD, and HIGH priority deliveries
- **Three Package Types**: Small, Standard, and Non-Standard packages with different handling requirements

## Architecture

### System Components

| Component | Description |
|-----------|-------------|
| **Hub** | Central distribution center that manages the entire network and coordinates branch operations |
| **Branch** | Regional distribution points that handle local package collection and delivery |
| **StandardTruck** | Weight-based capacity trucks for Hub-Branch transport |
| **NonStandardTruck** | Dimension-based capacity trucks for oversized packages |
| **Van** | Last-mile delivery vehicles for customer collection and delivery |
| **MainOffice** | System orchestrator (Singleton) managing time clock and package generation |

### Package Journey Flow

```
Customer (Sender)
    ↓ [Van Collection]
Local Branch (Storage)
    ↓ [StandardTruck Transport]
Central Hub (Sorting)
    ↓ [StandardTruck Transport]
Destination Branch (Storage)
    ↓ [Van Delivery]
Customer (Recipient) 
```

### Package Status States

1. **CREATION** - Package registered in the system
2. **COLLECTION** - Van collecting from sender
3. **BRANCH_STORAGE** - Stored at local branch
4. **HUB_TRANSPORT** - In transit to hub
5. **HUB_STORAGE** - Stored at central hub
6. **BRANCH_TRANSPORT** - In transit to destination branch
7. **DELIVERY** - Van delivering to recipient
8. **DISTRIBUTION** - Final distribution in progress
9. **DELIVERED** - Successfully delivered

## Design Patterns Implemented

This project showcases multiple software design patterns:

1. **Singleton Pattern** - MainOffice ensures single system controller
2. **Memento Pattern** - HubMemento and HubCareTaker for state management
3. **Strategy Pattern** - Package hierarchy with different implementations
4. **Factory Pattern** - Dynamic package creation based on criteria
5. **Template Method Pattern** - Abstract Truck class with specialized subclasses
6. **Observer Pattern** - GUI event handling and state updates
7. **Active Object Pattern** - Multi-threaded concurrent operations

## Technology Stack

- **Language**: Java (SE)
- **GUI Framework**: Java Swing
- **Concurrency**: Java Threading API
- **Collections**: java.util (ArrayList, List)
- **Graphics**: java.awt for custom rendering

## Project Structure

```
Post-Tracking-System/
├── src/
│   ├── components/           # Core business logic
│   │   ├── Package.java      # Abstract package base class
│   │   ├── StandardPackage.java
│   │   ├── SmallPackage.java
│   │   ├── NonStandardPackage.java
│   │   ├── Truck.java        # Abstract truck base class
│   │   ├── StandardTruck.java
│   │   ├── NonStandardTruck.java
│   │   ├── Van.java
│   │   ├── Branch.java       # Regional branch implementation
│   │   ├── Hub.java          # Central hub implementation
│   │   ├── MainOffice.java   # Singleton system controller
│   │   ├── HubMemento.java   # Memento pattern for state
│   │   ├── HubCareTaker.java # Memento caretaker
│   │   ├── Tracking.java     # Package journey record
│   │   ├── Node.java         # Interface for nodes
│   │   ├── Status.java       # Package status enum
│   │   ├── Priority.java     # Delivery priority enum
│   │   ├── Address.java      # Immutable address
│   │   └── Point.java        # 2D coordinates
│   └── program/              # GUI and presentation
│       ├── Main.java         # Application entry point
│       ├── PostSystemPanel.java  # Main visualization panel
│       ├── CreatePostSystemlDialog.java  # Configuration dialog
│       └── Customer.java     # Customer interface
├── .idea/                    # IntelliJ IDEA project files
├── tracking pack system.png  # Screenshot
└── README.md
```

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, NetBeans) or command line

### Running the Application

#### Using an IDE

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/Post-Tracking-System.git
   ```

2. Open the project in your IDE

3. Run the `Main.java` file located in `src/program/Main.java`

#### Using Command Line

```bash
# Navigate to the project directory
cd Post-Tracking-System

# Compile all Java files
javac -d bin src/components/*.java src/program/*.java

# Run the application
java -cp bin program.Main
```

## How to Use

1. **Create System**
   - Click "Create system" button
   - Configure the network:
     - Number of branches (1-10)
     - Trucks per branch (1-10)
     - Number of packages (2-20)
   - Click OK to initialize

2. **Start Simulation**
   - Click "Start" to begin the simulation
   - Watch packages move through the network in real-time

3. **Control Simulation**
   - **Stop**: Pause the simulation
   - **Resume**: Continue from paused state

4. **View Information**
   - **All packages info**: View table of all packages with their current status
   - **Branch info**: View inventory at specific branches

5. **Visual Elements**
   - **Green Rectangle**: Central Hub
   - **Blue/Cyan Rectangles**: Regional Branches
   - **Red Circles**: Customer locations
   - **Pink Circles**: Packages at locations
   - **Colored Rectangles with Wheels**: Trucks in transit
   - **Lines**: Network connections (blue: branch-hub, red: customer-branch, green: hub routes)

## Thread Safety

The system implements comprehensive thread safety through:
- Synchronized methods on shared resources
- wait()/notify() for inter-thread communication
- Atomic operations for state changes
- Thread suspension and resumption capabilities

## Future Enhancements

Potential improvements for the system:
- [ ] Save/Load simulation states
- [ ] Export tracking history to CSV/JSON
- [ ] Add delivery time estimation algorithms
- [ ] Implement route optimization for trucks
- [ ] Add package damage/loss simulation
- [ ] Support for international addresses
- [ ] Real-time statistics dashboard
- [ ] Custom truck scheduling algorithms

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## License

This project is available for educational purposes.

## Acknowledgments

This project demonstrates practical implementation of:
- Object-Oriented Programming principles
- Design Patterns in real-world scenarios
- Multi-threaded application development
- GUI programming with Java Swing
- Complex system simulation and visualization
