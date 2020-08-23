import React from 'react';
import {UserDashboardConnector} from '../connectors/user-dashborad-connector';
import {AdminDashboardConnector} from '../connectors/admin-dashboard-connector';

class Home extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            showDashBoard: false
        }
    }

    onChangeHandler(e) {
        console.log(e.target.value);
        if (e.target.value === '0') {
            this.props.setUser(e.target.value, 'admin');
        } else
            this.props.setUser(e.target.value, 'user');
        this.setState({showDashBoard: true});
    }

    showHome() {
        this.setState({showDashBoard: false});
        this.props.setSelectedJob(null);
    }

    render() {
        return (
            <div>
                <nav className='navbar navbar-expand-lg navbar-light bg-light'>
                    <p className='navbar-brand' onClick={() => this.showHome()}>Job Portal Home</p>
                    {this.props.role ? <p>{'Logged in as ' + this.props.role}</p> : null}
                    <input
                        className='btn btn-primary'
                        type='button'
                        value='Logout'
                        style={{'marginLeft': '70%'}}
                        onClick={() => this.showHome()}
                    />
                </nav>
                {this.state.showDashBoard
                    ? this.props.role === 'user'
                        ? <UserDashboardConnector/>
                        : <AdminDashboardConnector/>
                    : <div style={{'marginLeft': '20%'}}>
                        {'Login As'}
                        <br/>
                        <select onChange={(e) => this.onChangeHandler(e)}>
                            <option value=''>Select a user</option>
                            <option value='0'>Admin</option>
                            <option value='1'>Aakriti(Candidate)</option>
                            <option value='2'>Jordan(Candidate)</option>
                        </select>
                    </div>}
            </div>

        );
    }
}

export default Home;
