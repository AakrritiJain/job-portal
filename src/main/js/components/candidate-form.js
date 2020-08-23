import React from 'react';
import '../../resources/css/form.css';
import 'regenerator-runtime/runtime';
import JobList from './job-list';

class CandidateForm extends React.Component {
    constructor(props) {
        super(props);
    }

    async onSubmit(e) {
        e.preventDefault();
        this.props.setSelectedJob(null);
        await this.props.postJobRequest({
            'candidateId': this.props.userId,
            'jobId': this.props.selectedJob.id,
            'status': 'APPLIED',
            'email': this.state.email,
            'candidateName': this.state.firstName + ' ' + this.state.lastName,
            'contact': this.state.contact,
            'headline': this.state.headline
        });
    }

    onChangeHandler(attribute, value) {
        this.setState({[attribute]: value});
    }


    render() {
        return (
            <form className={'post-candidate-form'}
                  onSubmit={(e) => this.onSubmit(e)}
            >
                <div>
                    <JobList
                        job={this.props.selectedJob}
                        shouldShowFooter={false}
                        setSelectedJob={this.props.setSelectedJob}
                    />
                </div>
                <h6>Fill Application details</h6>
                <div className='input-group'>
                    <div className='form-group'>
                        <input type='text'
                               style={{'marginTop': '15px'}}
                               className='form-control'
                               placeholder='First Name'
                               aria-label='firstName'
                               aria-describedby='basic-addon1'
                               onChange={(e) => this.onChangeHandler('firstName', e.target.value)}
                        />
                    </div>
                </div>
                <div className='input-group'>
                    <div className='form-group'>
                        <input type='text'
                               className='form-control'
                               placeholder='Last Name'
                               aria-label='lastName'
                               aria-describedby='basic-addon1'
                               onChange={(e) => this.onChangeHandler('lastName', e.target.value)}
                        />
                    </div>
                </div>
                <div className='input-group'>
                    <div className='form-group'>
                        <input type='text'
                               className='form-control'
                               placeholder='Email'
                               aria-label='email'
                               aria-describedby='basic-addon1'
                               onChange={(e) => this.onChangeHandler('email', e.target.value)}
                        />
                    </div>
                </div>
                <div className='input-group'>
                    <div className='form-group'>
                        <input type='text'
                               className='form-control'
                               placeholder='Contact Number'
                               aria-label='contact'
                               aria-describedby='basic-addon1'
                               onChange={(e) => this.onChangeHandler('contact', e.target.value)}
                        />
                    </div>
                </div>
                <div className='input-group'>
                    <div className='form-group'>
                        <label htmlFor='exampleFormControlTextarea1'>Summary</label>
                        <textarea
                            className='form-control'
                            id='exampleFormControlTextarea1'
                            rows='3'
                            onChange={(e) => this.onChangeHandler('headline', e.target.value)}
                        />
                    </div>
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
                    onClick={() => this.props.setSelectedJob(null)}
                />
            </form>
        );
    }

}

export default CandidateForm;
