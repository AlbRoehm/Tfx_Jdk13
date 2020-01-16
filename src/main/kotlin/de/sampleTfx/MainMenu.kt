package de.sampleTfx

import tornadofx.*

class MainMenu : View() {
    override val root = borderpane {
		prefHeight = 300.0
		prefWidth = 400.0

        top = label {
            text = "Hello World"
        }
        center = button {
            text = "First Button"
            action { println("HelloButton") }
        }
        bottom = button {
            text = "AnotherButton"
        }
    }

    override fun onDock() {
        primaryStage.isResizable = false
        primaryStage.centerOnScreen()
        primaryStage.setOnCloseRequest {}
        super.onDock()
    }
}

