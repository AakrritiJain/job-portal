import React from 'react';
import {CITIES, SKILLS, YEARS} from '../util/constants';
import '../../resources/css/form.css';
import 'regenerator-runtime/runtime';

class PostJobForm extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            requiredSkills: ''
        }
    }

    async onSubmit(e) {
        e.preventDefault();
        this.props.toggleShowPostJobForm(false);
        await this.props.postJob(this.state);
    }

    onChangeHandler(attribute, value) {
        if (attribute === 'requiredSkills') {
            let requiredSkills = '';
            for (let i = 0; i < value.target.options.length; i++) {
                if (value.target.options[i].selected === true)
                    requiredSkills = requiredSkills + value.target.options[i].value + ',';
            }
            this.setState({'requiredSkills': requiredSkills});
        } else
            this.setState({[attribute]: value});
    }


    render() {
        return (
            <form className={'post-job-form'}
                  onSubmit={(e) => this.onSubmit(e)}
            >
                <div className='input-group'>
                    <div className='form-group'>
                        <label htmlFor='exampleFormControlTextarea1'>Headline</label>
                        <textarea className='form-control' id='exampleFormControlTextarea1' rows='3'
                                  onChange={(e) => this.onChangeHandler('headline', e.target.value)}/>
                    </div>
                </div>
                <div className='form-group'>
                    <label htmlFor='exampleFormControlSelect1'>Required Experience</label>
                    <select className='form-control' id='exampleFormControlSelect1'
                            onChange={(e) => this.onChangeHandler('requiredExperience', e.target.value)}>
                        <option value=''>{'Select required experience'}</option>
                        {YEARS.map((experience, index) => {
                            return (
                                <option value={experience} key={index}>{experience}</option>
                            );
                        })}
                    </select>
                </div>
                <div className='form-group'>
                    <label htmlFor='exampleFormControlSelect1'>Location</label>
                    <select className='form-control' id='exampleFormControlSelect1'
                            onChange={(e) => this.onChangeHandler('location', e.target.value)}>
                        <option value=''>{'Select a city'}</option>
                        {CITIES.map((city, index) => {
                            return (
                                <option value={city} key={index}>{city}</option>
                            );
                        })}
                    </select>
                </div>
                <div className='form-group'>
                    <label htmlFor='exampleFormControlSelect2'>Required Skills</label>
                    <select multiple className='form-control' id='exampleFormControlSelect2'
                            onChange={(e) => this.onChangeHandler('requiredSkills', e)}
                            title={'Use crtl to select multiple'}>
                        <option value='' disabled={true}>{'Select skills'}</option>
                        {SKILLS.map((skill, index) => {
                            return (
                                <option value={skill} key={index}>{skill}</option>
                            );
                        })}
                    </select>
                </div>
                <input
                    className='btn btn-primary'
                    type='submit'
                    value='Submit'
                    style={{'marginRight': '15px'}}
                />
                <input
                    className='btn btn-primary'
                    type='button'
                    value='Cancel'
                    onClick={() => this.props.toggleShowPostJobForm(false)}
                />
            </form>
        );
    }

}

export default PostJobForm;
