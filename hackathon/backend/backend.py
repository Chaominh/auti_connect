from flask import Flask, request, jsonify, render_template
import json

import pandas as pd
from datetime import datetime


app = Flask(__name__)

users = pd.read_csv('../backend/users.csv')
questions = pd.read_csv('../backend/questions.csv')



# Create 3D character interaction

def interact_with_character(user_input):
    """
    Interact with a 3D character based on user input.

    Args:
        user_input (str): User input.

    Returns:
        dict: A dictionary containing the voice response and other data.
            Example:
            {
                "voice_response": "Your character's voice response goes here.",
                "additional_data": "Any additional data related to the interaction."
            }
    """
    voice_response = "Your character's voice response goes here."
    additional_data = "Any additional data related to the interaction."

    response = {
        "voice_response": voice_response,
        "additional_data": additional_data
    }

    return response

# User login
@app.route('/api/users/login', methods=['POST'])
def login_user():
    data = request.get_json()
    phone = data['phone']
    password = data['password']

    user = next((user for user in users if user["phone"] == phone and user["password"] == password), None)
    if user:
        return jsonify(user)
    return jsonify({"error": "Phone number/password failed"}, 404)

# Route for 3D character interaction
@app.route('/api/character-interaction', methods=['POST'])
def character_interaction():
    data = request.get_json()
    user_input = data['input']
    character_response = interact_with_character(user_input)
    return jsonify({"response": character_response})

# Route for autism classification
@app.route('/api/classify-autism', methods=['POST'])
def classify_autism_endpoint():
    data = request.get_json()
    """
    Model train in other folder, it hasn't been done, but please find the model train we apply in this step in other folder (model_train_v2.ipynb)
    """
    return jsonify({"classification": classification_result})

# Route for the real-time dashboard 
@app.route('/dashboard', methods=['POST'])
def dashboard():
    data = request.get_json():
    """
    Generate dashboard report based on user interaction with the questions

    Args:
        response (str): User response.

    Returns:
        number of category questions have or no interaction, and visualize the result by dashboard
            }
    """

    # return render_template('dashboard.html', data=json.dumps(data))
